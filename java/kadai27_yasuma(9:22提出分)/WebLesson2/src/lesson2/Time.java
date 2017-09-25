package lesson2;

// フィールド
public class Time{
	private int id;  // 英語
	private String sleep;  // 英語
	private String wake; // 日本語

	// コンストラクタ
	public Time(int id, String sleep, String wake){
		this.id = id;
		this.sleep = sleep;
		this.wake = wake;
	}

	// メソッド
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getSleep(){
		return this.sleep;
	}
	public void setSleep(String sleep){
		this.sleep= sleep;
	}
	public String getWake(){
		return this.wake;
	}
	public void setWake(String wake){
		this.wake= wake;
	}


	// フィールド
	public class getTime{
		private long Hour;
		private long Minute;  // 英語
		private long Secound; // 日本語

	// コンストラクタ
	public getTime(long Hour, long Minute, long Secound){
		this.Hour = Hour;
		this.Minute = Minute;
		this.Secound = Secound;
	}

	// メソッド
	public long getHour(){
		return this.Hour;
	}
	public void getHour(long Hour){
		this.Hour= Hour;
	}
	public long getMinute() {
		return Minute;
	}

	public void setMinute(long minute) {
		Minute = minute;
	}

	public long getSecound() {
		return Secound;
	}

	public void setSecound(long secound) {
		Secound = secound;
	}

	public void setHour(long hour) {
		Hour = hour;
	}

}
}
