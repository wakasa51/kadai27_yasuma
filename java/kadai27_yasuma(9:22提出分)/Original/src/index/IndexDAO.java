package index;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IndexDAO {

	Connection con = null;
	PreparedStatement stmt_create= null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public String booklist(String user_id) {
		int result = 0;
		String index_list = null;
		try{
			// DB接続の記述
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8", "root", "");

			if(con != null){
				//DB接続成功の場合
				System.out.println("接続成功");
			}else{
				//DB接続失敗の場合
				result = 1;
			}

			ArrayList<String> tmp = new ArrayList<String>();
			//DBに登録されているか確認
			String sql = "SELECT * FROM user_book WHERE user_id != ? ORDER BY dt DESC LIMIT 12";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user_id);
			ResultSet rs = stmt.executeQuery();
			rs.last();
			int number_of_row = rs.getRow();
			System.out.println(number_of_row);
			rs.beforeFirst();
			System.out.println(rs);
				while(rs.next()){
					String t=null;
					String a=null;
					String i=null;
					String bid = rs.getString("book_id");
					sql = "SELECT * FROM bookdb WHERE book_id = ?";
					stmt = con.prepareStatement(sql);
					stmt.setString(1, bid);
					ResultSet rs0 = stmt.executeQuery();
					while(rs0.next()){
						t = rs0.getString("title");
						a = rs0.getString("author");
						i = rs0.getString("image");
						System.out.println(t);
					}
					Index idx = new Index(rs.getString("id"),
							rs.getString("user_id"),rs.getString("book_id"),
							rs.getString("review"), rs.getInt("rating"),
							rs.getInt("rental"), rs.getString("dt"), t, a, i);
					tmp.add(idx.toString());
				}
			String[] array=(String[])tmp.toArray(new String[0]);
			index_list = String.join("\n", array);
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
		return index_list;	// 結果を返す
	}
	public String nextindex(String user_id) {
		int result = 0;
		String index_list = null;
		try{
			// DB接続の記述
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8", "root", "");

			if(con != null){
				//DB接続成功の場合
				System.out.println("接続成功");
			}else{
				//DB接続失敗の場合
				result = 1;
			}

			String start = "0";
			String end = "12";
			ArrayList<String> tmp = new ArrayList<String>();
			//DBに登録されているか確認
			String sql = "SELECT * FROM user_book WHERE user_id != ? ORDER BY dt DESC LIMIT ?, ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, start);
			stmt.setString(2, end);
			ResultSet rs = stmt.executeQuery();
			rs.last();
			int number_of_row = rs.getRow();
			System.out.println(number_of_row);
			rs.beforeFirst();
			System.out.println(rs);
				while(rs.next()){
					String t=null;
					String a=null;
					String i=null;
					String bid = rs.getString("book_id");
					sql = "SELECT * FROM bookdb WHERE book_id = ?";
					stmt = con.prepareStatement(sql);
					stmt.setString(1, bid);
					ResultSet rs0 = stmt.executeQuery();
					while(rs0.next()){
						t = rs0.getString("title");
						a = rs0.getString("author");
						i = rs0.getString("image");
						System.out.println(t);
					}
					Index idx = new Index(rs.getString("id"),
							rs.getString("user_id"),rs.getString("book_id"),
							rs.getString("review"), rs.getInt("rating"),
							rs.getInt("rental"), rs.getString("dt"), t, a, i);
					tmp.add(idx.toString());
				}
			String[] array=(String[])tmp.toArray(new String[0]);
			index_list = String.join("\n", array);
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
		return index_list;	// 結果を返す
	}
}
