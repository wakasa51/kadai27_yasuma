package index;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		res.setCharacterEncoding("UTF-8");	//文字化け対策
		req.setCharacterEncoding("UTF-8");	//文字化け対策

		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		System.out.println(user_id);
		IndexDAO idx = new IndexDAO();
		String book_list = idx.booklist(user_id);
		session.setAttribute("book_list", book_list);
		System.out.println("book_list");

//		//セッションの情報を破棄
//		session.removeAttribute("id");
//		session.removeAttribute("pass");
//
//		//セッションそのものを破棄
//		session.invalidate();
		req.getRequestDispatcher("index.jsp").forward(req, res);
	}
}
