import java.util.ArrayList;
import java.util.Scanner;

public class ColLesson04 {
	public static void main(String[] args) {
		// Wordクラスのインスタンス配列
		ArrayList<Word> words = new ArrayList<Word>();

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
				words.add(word);
				index++;
				System.out.println("次の単語を入力してください。\"e\"で終了します。");
				input = sc.nextLine();
			}
		}
		catch(Exception e){
			//e.printStackTrace();
			System.out.println("\n登録制限を 越えました。登録済みのデータは以下になります。");
		}

		for(int i=0;i<words.size(); i++){
			System.out.println(words.get(i));
		}
		System.out.println(index + "件、登録しました。");
	}
}
