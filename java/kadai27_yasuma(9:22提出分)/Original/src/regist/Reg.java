package regist;

public class Reg{
	private String user_id;
	private String pass;
	private String mail;
	private String user_name;

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	//コンストラクタの設定
	public Reg(String user_id, String pass, String mail, String user_name){
		this.user_id = user_id;
		this.pass = pass;
		this.mail = mail;
		this.user_name = user_name;
	}
}

//参考：http://qiita.com/icelandnono/items/a54743ac8134a52e2ede