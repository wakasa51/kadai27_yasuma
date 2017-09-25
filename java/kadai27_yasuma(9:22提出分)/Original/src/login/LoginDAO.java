package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	public List<String> getUsers(String user_id, String pass) {
		List<String> user_session = new ArrayList<String>();
		user_session.add("no_err");
		try{
		// DB接続の記述
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8", "root", "");

			if(con != null){
				//DB接続成功の場合
				System.out.println("接続成功");
			}else{
				//DB接続失敗の場合
				 user_session.set(0, "err1");
			}
			// データベースからユーザー情報を取り出す。
			String SQL = "SELECT * FROM user_reg";
			stmt = con.prepareStatement(SQL);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String user_id1 = rs.getString("user_id");
				String pass1 = rs.getString("pass");
				if(user_id1.equals(user_id)){
					if(pass1.equals(pass)){
						System.out.println("認証OK");
						user_session.set(0, "certificate");
						user_session.add(user_id);
						user_session.add(pass);
						user_session.add(rs.getString("mail"));
						user_session.add(rs.getString("user_name"));
					}
				}
			}

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			user_session.set(0, "err2");
		}catch(SQLException e) {
			e.printStackTrace();
			user_session.set(0, "err2");
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
		return user_session;
	}
}