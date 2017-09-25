package bookreg;

public class BookReg{
	private String book_id;
	private String title;
	private String author;
	private String image;

	//アクセサーの設定
	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
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
	public BookReg(String book_id, String title, String author, String image){
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.image = image;
	}
}