package day04_String;
import java.util.Scanner;

public class swea_String {

	public static void main(java.lang.String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int T = sc.nextInt();
			String search = sc.next();
			char[] charArr = sc.next().toCharArray();
			int len = charArr.length;
			int cnt = 0;
			//문자열은 처음부터 비교
			for(int i = 0;i<=len-search.length();i++) {
				String answer = "";
				//패턴의 처음부터 비교
				for(int j=0;j<search.length();j++) {
					//비교문자열을 한칸씩 미루면서 합친다
					answer += charArr[i+j];
				}
				//합쳐진 문자열이 패턴과 같으면 +1
				if(answer.equals(search))
				cnt++;//패턴의 개수
			}
			System.out.printf("#%d %d",t,cnt);
			System.out.println();
			
		}

	}

}
