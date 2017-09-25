package login;

public class Login{
	private String user_id;
	private String pass;

	//アクセサーの設定
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	//コンストラクタの設定
	public Login(String user_id, String pass){
		this.user_id = user_id;
		this.pass = pass;
	}
}