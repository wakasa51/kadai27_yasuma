package regist;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		res.setCharacterEncoding("UTF-8");	//文字化け対策
		req.setCharacterEncoding("UTF-8");	//文字化け対策

		//変数の受け取り
		String user_id = req.getParameter("user_id");
		String pass = req.getParameter("pass");
		String mail = req.getParameter("mail");
		String user_name = req.getParameter("user_name");

		//入力内容の確認
		if(user_id == null || user_id.length()==0 || pass == null || pass.length()==0 || mail == null || mail.length()==0 || user_name == null || user_name.length()==0){
			req.setAttribute("message", "入力されていない項目があります。");
			req.getRequestDispatcher("certmsg.jsp").forward(req, res);
		}else{
			//データベースへの登録
			int result=0;
			URegDAO ur = new URegDAO();
			result = ur.registUsers(user_id, pass, mail, user_name);
			if(result==1){
				req.setAttribute("message", "データベースの接続に失敗しました。大変申し訳ありませんが、再度入力をお願いいたします。");
				req.getRequestDispatcher("certmsg.jsp").forward(req, res);
			}else if(result ==2){
				req.setAttribute("message", "エラーが発生しました。大変申し訳ありませんが、時間を置いて再度登録してください。");
				req.getRequestDispatcher("certmsg.jsp").forward(req, res);
			}
			req.setAttribute("message", "登録が完了しました。ログインしてください。");
			req.getRequestDispatcher("certmsg.jsp").forward(req, res);
		}
	}
}
