package msg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybook.MyBookDAO;

public class MsgServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		res.setCharacterEncoding("UTF-8");	//文字化け対策
		req.setCharacterEncoding("UTF-8");	//文字化け対策

		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		MyBookDAO idx = new MyBookDAO();
		String book_list = idx.booklist(user_id);
		session.setAttribute("book_list", book_list);
		System.out.println("book_list");

		req.getRequestDispatcher("index.jsp").forward(req, res);
	}
}
