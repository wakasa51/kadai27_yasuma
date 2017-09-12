import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WordDAO {

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public int registWords(ArrayList<Word> words, int index) {
		int result = 0;
		try{
			// DB接続の記述
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8", "root", "");

			if(con != null){
				//System.out.println("DB接続完了(getConnection後)\r\n....");
			}else{
				System.out.println("DB接続失敗\r\n.....");
			}
			// ここに日本語と英単語を登録する文
			String SQL = "INSERT INTO dictionary VALUES(?, ?)";
			Word w = words.get(index);
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, w.getEnglish());
			stmt.setString(2, w.getJapanese());

			int count = stmt.executeUpdate();

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
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

	public List<Word> getWords() {
		List<Word> dbword = new ArrayList<Word>();
		try{
			// DB接続の記述
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8", "root", "");

			if(con != null){
				//System.out.println("DB接続完了(getConnection後)\r\n....");
			}else{
				System.out.println("DB接続失敗\r\n.....");
			}
			// ここに日本語と英単語をデータベースから取得する文
			String SQL = "SELECT * FROM dictionary";
			stmt = con.prepareStatement(SQL);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String english = rs.getString("english");
				String japanese = rs.getString("japanese");
				Word word = new Word(english, japanese);
				dbword.add(word);
			}

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
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
		return dbword;
	}

}
