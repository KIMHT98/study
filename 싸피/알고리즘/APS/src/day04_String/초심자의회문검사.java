package day04_String;
import java.util.Scanner;

public class 초심자의회문검사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t= 1;t<=T;t++) {
			String word = sc.next();
			int len = word.length();
			String answer = "";//단어 뒤집은 결과 저장소
			int result = 0;
			//문자열 뒤집기
			for(int i = len-1;i>=0;i--) {
				answer += word.charAt(i);
			}
			if(word.equals(answer))
				result = 1;
			System.out.printf("#%d %d",t,result);
			System.out.println();
		}

	}

}
