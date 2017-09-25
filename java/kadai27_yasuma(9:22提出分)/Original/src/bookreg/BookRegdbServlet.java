package bookreg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookRegdbServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		res.setCharacterEncoding("UTF-8");	//文字化け対策
		req.setCharacterEncoding("UTF-8");	//文字化け対策

		//変数の受け取り
		String user_id = req.getParameter("user_id");
		String book_id = req.getParameter("book_id");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String image = req.getParameter("image");
		String review = req.getParameter("review");
		Integer rating = Integer.parseInt(req.getParameter("rating"));
		Integer rental = Integer.parseInt(req.getParameter("rental"));

		BookRegDAO brg = new BookRegDAO();
		int result = brg.registUserbook(user_id, book_id, review, rating, rental);
		if(result==1){
			req.setAttribute("message", "データベースの接続に失敗しました。大変申し訳ありませんが、再度入力をお願いいたします。");
			req.getRequestDispatcher("certmsg.jsp").forward(req, res);
		}else if(result ==2){
			req.setAttribute("message", "エラーが発生しました。大変申し訳ありませんが、時間を置いて再度登録してください。");
			req.getRequestDispatcher("certmsg.jsp").forward(req, res);
		}
		System.out.println("OK!");
		result = brg.registbook(book_id, title, author, image);
		if(result==1){
			req.setAttribute("message", "データベースの接続に失敗しました。大変申し訳ありませんが、再度入力をお願いいたします。");
			req.getRequestDispatcher("certmsg.jsp").forward(req, res);
		}else if(result ==2){
			req.setAttribute("message", "エラーが発生しました。大変申し訳ありませんが、時間を置いて再度登録してください。");
			req.getRequestDispatcher("certmsg.jsp").forward(req, res);
		}
		System.out.println("OK!");

		HttpSession session = req.getSession(true);
		session.setAttribute("user_id", user_id);

//		//セッションの情報を破棄
//		session.removeAttribute("id");
//		session.removeAttribute("pass");
//
//		//セッションそのものを破棄
//		session.invalidate();
		req.getRequestDispatcher("index").forward(req, res);
	}
}
