package searchbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

public class SearchBookServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		res.setCharacterEncoding("UTF-8");	//文字化け対策
		req.setCharacterEncoding("UTF-8");	//文字化け対策

		//変数の受け取り
		String book_name = req.getParameter("book_name");
		String user_id = req.getParameter("user_id");

		//半角や全角スペースが入っていると検索できないので、google books apiに合わせて"+"に変換
		book_name = book_name.replaceAll(" ", "+");
		book_name = book_name.replaceAll("　", "+");
		//変換後URLとして入れる
		String url = "https://www.googleapis.com/books/v1/volumes?q="+book_name;

		StringBuilder builder = new StringBuilder();
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(url);
		try {
			//リクエストしたリンクが存在するか確認するために、HTTPリクエストを送ってHTTPレスポンスを取得する
			HttpResponse response = client.execute(httpGet);
			//返却されたHTTPレスポンスの中のステータスコードを調べる
			// -> statusCodeが200だったらページが存在。404だったらNot found（ページが存在しない）。500はInternal server error。
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				//HTTPレスポンスが200よりページは存在する
				//レスポンスからHTTPエンティティ（実体）を生成
				HttpEntity entity = response.getEntity();
				//HTTPエンティティからコンテント（中身）を生成
				InputStream content = entity.getContent();
				//コンテントからInputStreamReaderを生成し、さらにBufferedReaderを作る
				BufferedReader reader = new BufferedReader(new InputStreamReader(content));
				String line;
				//readerからreadline()で行を読んで、builder文字列(StringBuilderクラス)に格納していく。
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
			} else {
				System.out.println("Failed to download file");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ArrayList<Book> jsonData = new ArrayList<Book>();
		try {
			// 文字列をJSONオブジェクトに変換する
			JSONObject job = new JSONObject(builder.toString());
			JSONArray jsonArray = job.getJSONArray("items");
			//JSON Arrayのサイズを表示
			System.out.println("Number of entries " + jsonArray.length());
			//JSON Objectを作成する
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String img_url;
				if(jsonObject.getJSONObject("volumeInfo").getJSONObject("readingModes").getBoolean("image")==true){
					img_url = jsonObject.getJSONObject("volumeInfo").getJSONObject("imageLinks").getString("thumbnail");
				}else{
					img_url = "http://design-ec.com/d/e_others_50/l_e_others_500.png";
				}
				String author;
				if(jsonObject.getJSONObject("volumeInfo").isNull("authors")==true){
					author = "著者不明";
				}else{
					author = jsonObject.getJSONObject("volumeInfo").getJSONArray("authors").get(0).toString();
				}
				Book book = new Book(jsonObject.getString("id")
						,jsonObject.getJSONObject("volumeInfo").getString("title")
						,author
						,img_url);
				jsonData.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> tmp = new ArrayList<String>();
		for(int i=0; i<jsonData.size();i++){
			tmp.add(jsonData.get(i).toString(user_id));
		}
		String[] array=(String[])tmp.toArray(new String[0]);
		String search_result = String.join("\n", array);
		HttpSession session = req.getSession(true);
		session.setAttribute("search_result", search_result);
//		//セッションの情報を破棄
//		session.removeAttribute("id");
//		session.removeAttribute("pass");
//
//		//セッションそのものを破棄
//		session.invalidate();
		req.getRequestDispatcher("result.jsp").forward(req, res);
	}
}
