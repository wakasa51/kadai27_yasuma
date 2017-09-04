import java.util.Scanner;

public class ColLesson02 {
	public static void main(String[] args) {
		// Wordクラスのインスタンス配列
		Word[] words = new Word[10];

		// コマンドラインから入力
		System.out.println("英単語と日本語をスペースで区切って入力して下さい。");
		Scanner sc  = new Scanner(System.in);
		String input = sc.nextLine();

		// ここから記述してください

		int index = 0;
		try{
			while(!input.equals("e")){
				// 例えば、「apple  りんご」と入力されたときはtmp[0]に"apple"、tmp[1]に"りんご"が入る
				String[] tmp = input.split(" ");
				Word word = new Word(tmp[0], tmp[1]);
				words[index] = word;
				index++;
				System.out.println("次の単語を入力してください。\"e\"で終了します。");
				input = sc.nextLine();
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("用意した配列を容量をオーバーしました。");
		}

		for(int i=0;i<index; i++){
			System.out.println(words[i]);
		}
		System.out.println(index + "件、登録しました。");
	}
}
