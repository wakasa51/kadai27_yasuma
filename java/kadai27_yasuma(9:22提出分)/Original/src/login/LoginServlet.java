package login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		res.setCharacterEncoding("UTF-8");	//文字化け対策
		req.setCharacterEncoding("UTF-8");	//文字化け対策

		//変数の受け取り
		String user_id = req.getParameter("user_id");
		String pass = req.getParameter("pass");
		//入力内容の確認
		if(user_id == null || user_id.length()==0 || pass == null || pass.length()==0){
			req.setAttribute("message", "入力されていない項目があります。");
			req.getRequestDispatcher("certmsg.jsp").forward(req, res);
		}else{
			//データベースへの登録
			String result;
			LoginDAO lg = new LoginDAO();
			List<String> user_session = lg.getUsers(user_id, pass);
			result = user_session.get(0);
			if(result== "err1"){
				req.setAttribute("message", "データベースの接続に失敗しました。\n大変申し訳ありませんが、再度ログインをお願いいたします。");
				req.getRequestDispatcher("certmsg.jsp").forward(req, res);
			}else if(result == "err2"){
				req.setAttribute("message", "エラーが発生しました。\n大変申し訳ありませんが、時間を置いて再度ログインしてください。");
				req.getRequestDispatcher("certmsg.jsp").forward(req, res);
			}else if(result == "no_err"){
				req.setAttribute("message", "ログイン認証できませんでした。\n再度入力してください。");
				req.getRequestDispatcher("certmsg.jsp").forward(req, res);
			}else{
				HttpSession session = req.getSession(true);
				session.setAttribute("user_id", user_session.get(1));
				session.setAttribute("pass", user_session.get(2));
				session.setAttribute("mail", user_session.get(3));
				session.setAttribute("user_name", user_session.get(4));
				req.getRequestDispatcher("index").forward(req, res);
			}
		}
	}
}
