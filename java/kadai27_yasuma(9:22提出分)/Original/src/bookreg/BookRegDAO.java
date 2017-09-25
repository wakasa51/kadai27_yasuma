package bookreg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRegDAO {

	Connection con = null;
	PreparedStatement stmt_create= null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public int registUserbook(String user_id, String book_id, String review, int rating, int rental) {
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


			UserBookReg r = new UserBookReg(user_id, book_id, review, rating, rental);
			int check = 0;
			String sql = "SELECT * FROM user_book";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

				while(rs.next()){
					String user_id0 = rs.getString("user_id");
					String book_id0 = rs.getString("book_id");
					if(user_id0.equals(user_id) &&book_id0.equals(book_id)){
						String SQL = "UPDATE user_book SET review=?, rating=?, rental=?, dt=? WHERE user_id=? AND book_id=?";
						stmt = con.prepareStatement(SQL);
						stmt.setString(1, r.getReview());
						stmt.setInt(2, r.getRating());
						stmt.setInt(3, r.getRental());
						stmt.setString(4, r.getDt());
						stmt.setString(5, r.getUser_id());
						stmt.setString(6, r.getBook_id());

						int count = stmt.executeUpdate();
						check = 1;
						break;
					}
				}
				if(check==0){
					// 情報を登録する
					String SQL = "INSERT INTO user_book VALUES(null, ?, ?, ?, ?, ? ,?)";
					stmt = con.prepareStatement(SQL);
					stmt.setString(1, r.getUser_id());
					stmt.setString(2, r.getBook_id());
					stmt.setString(3, r.getReview());
					stmt.setInt(4, r.getRating());
					stmt.setInt(5, r.getRental());
					stmt.setString(6, r.getDt());
					System.out.println("登録してみたよ！");

					int count = stmt.executeUpdate();
				}

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			result = 2;
		}catch(SQLException e) {
			e.printStackTrace();
			result = 2;
		}
		return result;	// 結果を返す
	}

	public int registbook(String book_id, String title, String author, String image) {
		int result = 0;
		System.out.println("登録ちゃねレンジ！");
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

			//DBに登録されているか確認
			String sql = "SELECT book_id FROM bookdb";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int check = 0;
				while(rs.next()){
					String book_id1 = rs.getString("book_id");
					if(book_id1.equals(book_id)){
						System.out.println("既にデータが存在");
						check = 1;
						break;
					}
				}
				if(check==0){
					//idがなければ、本の情報を登録する
					String SQL = "INSERT INTO bookdb VALUES(?, ?, ?, ?)";
					BookReg br = new BookReg(book_id, title, author, image);
					stmt = con.prepareStatement(SQL);
					stmt.setString(1, br.getBook_id());
					stmt.setString(2, br.getTitle());
					stmt.setString(3, br.getAuthor());
					stmt.setString(4, br.getImage());
					int count = stmt.executeUpdate();
					System.out.println("登録しました");
				}
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
