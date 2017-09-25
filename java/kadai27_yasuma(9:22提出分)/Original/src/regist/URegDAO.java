package regist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class URegDAO {

	Connection con = null;
	PreparedStatement stmt_create= null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public int registUsers(String user_id, String pass, String mail, String user_name) {
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
			String SQL = "INSERT INTO user_reg VALUES(?, ?, ?, ?)";
			Reg r = new Reg(user_id, pass, mail, user_name);
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, r.getUser_id());
			stmt.setString(2, r.getPass());
			stmt.setString(3, r.getMail());
			stmt.setString(4, r.getUser_name());

			int count = stmt.executeUpdate();

//			//ユーザーのテーブルを作成する。
//			con = DriverManager.getConnection("jdbc:mysql://localhost/user_info?useUnicode=true&characterEncoding=utf8", "root", "");
//
//			if(con != null){
//				//DB接続成功の場合
//			}else{
//				//DB接続失敗の場合
//				result = 1;
//			}
//			System.out.println(r.getUser_id());
//			String sql = "CREATE TABLE "+r.getUser_id()+"(name char(100) PRIMARY KEY , recommend text(400), rating int , date datetime) COLLATE utf8_unicode_ci";
//			stmt_create = con.prepareStatement(sql);
//			stmt_create.execute();

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
