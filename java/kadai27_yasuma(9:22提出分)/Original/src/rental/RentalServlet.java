package rental;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RentalServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		res.setCharacterEncoding("UTF-8");	//文字化け対策
		req.setCharacterEncoding("UTF-8");	//文字化け対策

		String book_id = req.getParameter("book_id");
		String send_user = req.getParameter("send_user");
		String receive_user = req.getParameter("receive_user");
		String rental_period = req.getParameter("rental_period");
		String how_receive = req.getParameter("how_receive");
		String msg = req.getParameter("msg");
		System.out.println();

		HttpSession session = req.getSession(true);
		SendMsgDAO sm = new SendMsgDAO();
		int result = sm.sendmsg(book_id, send_user, receive_user, rental_period, how_receive, msg);
		if(result==1){
			req.setAttribute("message", "データベースの接続に失敗しました。大変申し訳ありませんが、再度入力をお願いいたします。");
			req.getRequestDispatcher("certmsg.jsp").forward(req, res);
		}else if(result ==2){
			req.setAttribute("message", "エラーが発生しました。大変申し訳ありませんが、時間を置いて再度登録してください。");
			req.getRequestDispatcher("certmsg.jsp").forward(req, res);
		}

//		//セッションの情報を破棄
//		session.removeAttribute("id");
//		session.removeAttribute("pass");
//
//		//セッションそのものを破棄
//		session.invalidate();
		req.getRequestDispatcher("index.jsp").forward(req, res);
	}
}
