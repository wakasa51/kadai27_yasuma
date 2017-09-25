package rental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SendMsgDAO {

	Connection con = null;
	PreparedStatement stmt_create= null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public int sendmsg(String book_id, String send_user, String receive_user, String rental_period, String how_receive, String msg) {
		int result = 0;
		try{
			// DB接続の記述
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8", "root", "");

			if(con != null){
				//DB接続成功の場合
			}else{
				//DB接続失敗の場合
				result = 1;
			}

			// ユーザー情報を登録する
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = new Date();
			String SQL = "INSERT INTO msg VALUES(null, ?, ?, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, book_id);
			stmt.setString(2, send_user);
			stmt.setString(3, receive_user);
			stmt.setString(4, rental_period);
			stmt.setString(5, how_receive);
			stmt.setString(6, msg);
			stmt.setString(7, f.format(now));

			int count = stmt.executeUpdate();
			System.out.println("メッセージ送信");

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			result = 2;
		}catch(SQLException e) {
			e.printStackTrace();
			result = 2;
		}finally{
			if ( stmt != null) {
				try {
					stmt.close();
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
		return result;	// 結果を返す
	}
}
