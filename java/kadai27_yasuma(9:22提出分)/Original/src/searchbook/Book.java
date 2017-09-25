package searchbook;

public class Book{
	private String id;
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
	public Book(String id, String title, String author, String image){
		this.id = id;
		this.title = title;
		this.author = author;
		this.image = image;
	}

	public String toString(String user_id){
		return "<div class=\"book-item\">\n<img class=\"book-img\" src="
	+ this.image + " alt=" + this.title + ">\n<p class=\"book-text book-title\">"
	+ this.title + "</p>\n<p class=\"book-text book-author\">"
	+ this.author + "</p><form action=\"book_reg\" method=\"post\">"
	+"<input type=\"hidden\" name=\"book_id\" value="+this.id+">"
	+"<input type=\"hidden\" name=\"title\" value="+this.title+">"
	+"<input type=\"hidden\" name=\"author\" value="+this.author+">"
	+"<input type=\"hidden\" name=\"image\" value="+this.image+">"
	+"<input type=\"hidden\" name=\"user_id\" value="+user_id+">"
	+"<button type=\"submit\" name=\"book-reg\" class=\"breg-btn\">本を登録する</button></form>\n</div>";
	}

}

//参考：http://qiita.com/icelandnono/items/a54743ac8134a52e2ede