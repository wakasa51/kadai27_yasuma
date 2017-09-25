package index;

public class Index{
	private String id;
	private String user_id;
	private String book_id;
	private String review;
	private String rating;
	private String rental;
	private String dt;
	private String title;
	private String author;
	private String image;

	//アクセサーの設定
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getRental() {
		return rental;
	}

	public void setRental(String rental) {
		this.rental = rental;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	//コンストラクタの設定
	public Index(String id, String user_id, String book_id, String review, int rating, int rental, String dt, String title, String author, String image){
		this.id = id;
		this.user_id = user_id;
		this.book_id = book_id;
		this.review = review;
		this.dt = dt;
		this.author = author;
		this.title = title;
		this.image = image;
		if(rating==1){
			this.rating = "☆  ";
		}else if(rating==2){
			this.rating = "☆☆ ";
		}else{
			this.rating = "☆☆☆";
		}

		if(rental==0){
			this.rental = "×";
		}else{
			this.rental = "○";
		}

	}

	public String toString(){
		return "<div class=\"idx-item\"><p class=\"book-text user-name\">"
	+ this.user_id + "さんの本</p>\n<img class=\"book-img\" src="
	+ this.image + " alt=" + this.title + ">\n<p class=\"book-text book-title\">"
	+ this.title + "</p>\n<p class=\"book-text book-author\">"
	+ this.author + "</p><p class=\"book-text book-rr\">評価："
	+ this.rating + " レンタル："+ this.rental+ "</p><form action=\"description\" method=\"post\">"
	+"<input type=\"hidden\" name=\"id\" value="+this.id+">"
	+"<input type=\"hidden\" name=\"user_id\" value="+this.user_id+">"
	+"<input type=\"hidden\" name=\"book_id\" value="+this.book_id+">"
	+"<input type=\"hidden\" name=\"review\" value="+this.review+">"
	+"<input type=\"hidden\" name=\"rating\" value="+this.rating+">"
	+"<input type=\"hidden\" name=\"rental\" value="+this.rental+">"
	+"<input type=\"hidden\" name=\"dt\" value="+this.dt+">"
	+"<input type=\"hidden\" name=\"title\" value="+this.title+">"
	+"<input type=\"hidden\" name=\"author\" value="+this.author+">"
	+"<input type=\"hidden\" name=\"image\" value="+this.image+">"
	+"<button type=\"submit\" name=\"book-reg\" class=\"breg-btn\">詳細を見る</button></form>\n</div>";
	}

}

//参考：http://qiita.com/icelandnono/items/a54743ac8134a52e2ede