package Reg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		res.setCharacterEncoding("UTF-8");	//文字化け対策

		HttpSession session = req.getSession(true);
		session.setAttribute("english", req.getParameter("english"));
		session.setAttribute("japanese", req.getParameter("japanese"));

		String english = req.getParameter("english");
		String japanese = req.getParameter("japanese");
		ArrayList<Word> words = new ArrayList<Word>();
		Word word = new Word(english, japanese);
		words.add(word);
		WordDAO adddata = new WordDAO();
		adddata.registWords(words);
		int i = words.size();

		WordDAO wdao = new WordDAO();
		List<Word> dbword = wdao.getWords();
		int j = dbword.size();

		session.setAttribute("i", i);
		session.setAttribute("j", j);


		req.getRequestDispatcher("result.jsp").forward(req, res);
//
//		//セッションの情報を破棄
//		session.removeAttribute("id");
//		session.removeAttribute("pass");
//
//		//セッションそのものを破棄
//		session.invalidate();
	}
}
