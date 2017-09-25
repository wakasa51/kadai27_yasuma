package bookreg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookRegServlet extends HttpServlet {
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

		HttpSession session = req.getSession(true);
		session.setAttribute("user_id", user_id);
		session.setAttribute("book_id", book_id);
		session.setAttribute("title", title);
		session.setAttribute("author", author);
		session.setAttribute("image", image);

//		//セッションの情報を破棄
//		session.removeAttribute("id");
//		session.removeAttribute("pass");
//
//		//セッションそのものを破棄
//		session.invalidate();
		req.getRequestDispatcher("bookreg.jsp").forward(req, res);
	}
}
