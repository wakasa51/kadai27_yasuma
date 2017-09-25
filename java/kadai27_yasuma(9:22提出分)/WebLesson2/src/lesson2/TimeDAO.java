package lesson2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class TimeDAO {

	Connection con = null;
	PreparedStatement st = null;

	static String URL = "jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8";
	static String USER = "root";
	static String PW = "";

	public int registTime(List<Time> lists){

		int result = 0;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PW);
			String SQL = "INSERT INTO sleep_tb VALUES(?,?,?)";


			for(Time tm : lists){
				st = con.prepareStatement(SQL);

				st.setInt(1, tm.getId());
				st.setString(2, tm.getSleep());
				st.setString(3, tm.getWake());
				st.executeUpdate();
				result++;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if ( con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;

	}
	public Long[] getTime() {
//	public String getTime() {
		ResultSet rs = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateTo = null;
	    Date dateFrom = null;
	    Long[] dayDiff = new Long[3];
//	    String dayDiff = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PW);

			if(con != null){
				System.out.println("繋がりました");
				String SQL = "SELECT * FROM sleep_tb WHERE id=(SELECT MAX(id) FROM sleep_tb) ";

//				id が最大のものを取ってくる

				st = con.prepareStatement(SQL);
				rs = st.executeQuery();
				while(rs.next()) {

				String culcsleep = rs.getString("sleep");
				String culcwake = rs.getString("wake");

				System.out.println(culcsleep);

				try {
					dateFrom =sdf.parse(culcsleep);
					dateTo =sdf.parse(culcwake);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				long dateTimeTo = dateTo.getTime();
				long dateTimeFrom = dateFrom.getTime();

				System.out.println(dateTimeTo);
				System.out.println(dateTimeFrom);

				Long Hour = ( dateTimeTo - dateTimeFrom ) / (1000 * 60 * 60 );
				Long Minute = ( dateTimeTo - dateTimeFrom ) / (1000 * 60 ) % 60 ;
				Long Secound = ( dateTimeTo - dateTimeFrom ) / (1000) % 60 ;

				dayDiff[0] = Hour;
				dayDiff[1] = Minute;
				dayDiff[2] = Secound;
//				dayDiff = Hour + "時間" +Minute + "分"+ Secound + "秒";

				System.out.println(dayDiff);
				}
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dayDiff;
	}
}
