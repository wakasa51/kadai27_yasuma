package description;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DescriptionServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		res.setCharacterEncoding("UTF-8");	//文字化け対策
		req.setCharacterEncoding("UTF-8");	//文字化け対策

		String id = req.getParameter("id");
		String own_user_id = req.getParameter("user_id");
		String book_id = req.getParameter("book_id");
		String review = req.getParameter("review");
		String rating = req.getParameter("rating");
		String rental = req.getParameter("rental");
		String dt = req.getParameter("dt");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String image = req.getParameter("image");
		System.out.println(rating);
		System.out.println(rental);

		HttpSession session = req.getSession(true);
		session.setAttribute("own_user_id", own_user_id);
		session.setAttribute("book_id", book_id);
		session.setAttribute("title", title);
		session.setAttribute("author", author);
		session.setAttribute("image", image);
		session.setAttribute("review", review);
		session.setAttribute("rating", rating);
		String rental_btn = "";
		if(rental.equals("○")){
			rental_btn ="<button type=\"submit\" name=\"book-rental\" class=\"book-rental-btn\" formaction=\"msg.jsp\">借りたい！</button>";
		}
		session.setAttribute("rental_btn", rental_btn);

//		//セッションの情報を破棄
//		session.removeAttribute("id");
//		session.removeAttribute("pass");
//
//		//セッションそのものを破棄
//		session.invalidate();
		req.getRequestDispatcher("description.jsp").forward(req, res);
	}
}
