package lesson2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class ResistServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession(true);
		session.setAttribute("sleep", req.getParameter("sleep"));

		int id = 0;
		String sleep = req.getParameter("sleep");
		String wake = req.getParameter("wake");


		req.setAttribute("id", id);
		req.setAttribute("sleep",sleep);
		req.setAttribute("wake",wake);


		TimeDAO dao = new TimeDAO();
		List<Time>lists = new ArrayList<>();
		lists.add(new Time(id, sleep, wake));
		int count = dao.registTime(lists);
		String result = String.valueOf(count);
		req.setAttribute("result",result);

		Long[] dayDiff= dao.getTime();
		String hour = String.valueOf(dayDiff[0]);
		req.setAttribute("hour",hour);
		String minute = String.valueOf(dayDiff[1]);
		req.setAttribute("minute",minute);
		String secound = String.valueOf(dayDiff[2]);
		req.setAttribute("secound",secound);



		req.getRequestDispatcher("result.jsp").forward(req,res);
	}


}




