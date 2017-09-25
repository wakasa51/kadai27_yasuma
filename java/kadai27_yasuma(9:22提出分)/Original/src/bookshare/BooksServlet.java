package bookshare;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class BooksServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		res.setCharacterEncoding("UTF-8");	//文字化け対策
		req.setCharacterEncoding("UTF-8");	//文字化け対策
		
		StringBuilder builder = new StringBuilder();
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet("https://api.twitter.com/1/statuses/user_timeline.json?screen_name=takapon_jp");
		HttpResponse response = httpClient.execute(httpGet);

//		HttpSession session = req.getSession(true);
//		session.setAttribute("english", req.getParameter("english"));
//		session.setAttribute("japanese", req.getParameter("japanese"));		String english = req.getParameter("english");

//		req.getRequestDispatcher("result.jsp").forward(req, res);
//
//		//セッションの情報を破棄
//		session.removeAttribute("id");
//		session.removeAttribute("pass");
//
//		//セッションそのものを破棄
//		session.invalidate();
	}
}
