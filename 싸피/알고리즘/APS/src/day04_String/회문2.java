package day04_String;
import java.util.Scanner;

public class 회문2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int T = sc.nextInt();
			char[][] arr = new char[100][100];
			for (int r = 0; r < 100; r++) {
				String row = sc.next();
				arr[r] = row.toCharArray();
			}
			int max = 0;
			//가로방향 확인
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					//(0,0)부터 시작해서 문자를 하나씩 더해서 문자열을 만든다.
					String str = "";
					int len = 0;
					for (int i = 0; i < 100 - c; i++) {
						str += arr[r][c + i];
						//만든 문자열 뒤집기
						StringBuffer sb = new StringBuffer(str);
						//문자열이 회문인지 확인
						if (sb.reverse().toString().equals(str))
							len = str.length();//회문이면 길이 저장
						if (len > max)
							max = len;//최댓값 추출
					}
				}
			}
			//세로방향 확인
			for (int c = 0; c < 100; c++) {
				for (int r = 0; r < 100; r++) {
					//(0,0)부터 시작해서 문자 하나씩 더해서 문자열 만들기
					String str = "";
					int len = 0;
					for (int i = 0; i < 100 - r; i++) {
						str += arr[r+i][c];
						//만든 문자열 뒤집기
						StringBuffer sb = new StringBuffer(str);
						//회문인지 확인
						if (sb.reverse().toString().equals(str))
							len = str.length();//회문이면 길이 저장
						if (len > max)
							max = len;//최댓값 추출
					}
				}
			}
			System.out.printf("#%d %d",t,max);
			System.out.println();

		}
	}

}
