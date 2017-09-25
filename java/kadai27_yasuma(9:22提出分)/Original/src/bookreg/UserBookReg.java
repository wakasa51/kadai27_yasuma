package bookreg;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserBookReg{
	private String user_id;
	private String book_id;
	private String review;
	private int rating;
	private int rental;
	private String dt;

	//アクセサーの設定
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getRental() {
		return rental;
	}

	public void setRental(int rental) {
		this.rental = rental;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}
	//コンストラクタの設定
	public UserBookReg(String user_id, String book_id, String review, int rating, int rental){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		this.user_id = user_id;
		this.book_id = book_id;
		this.review = review;
		this.rating = rating;
		this.rental =rental;
		this.dt = f.format(now);
	}
}