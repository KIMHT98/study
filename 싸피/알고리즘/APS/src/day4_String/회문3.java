package day4_String;
import java.util.Scanner;

public class 회문3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1;t<=10;t++) {
			int T = sc.nextInt();
			char[][] arr = new char[100][100];
			for(int r=0;r<100;r++) {
				arr[r] = sc.next().toCharArray();
			}
			int maxlength = 1;
			for(int r=0;r<100;r++) {
				for(int c=0;c<100;c++) {
					int d=0;//기준점에서의 거리
					//1.가로에서 길이가 홀수일때
					//(r,c)를 기준으로 양옆을 확인
					//양옆이 같으면 회문이므로 한칸씩 늘려가면서 확인
					while(c+d<100&&c-d>=0&&arr[r][c+d]==arr[r][c-d]) {
						d++;
						//d는 문자열을 반으로 나눈 것
						//문자열의 길이가 홀수이므로 2*d-1을 해야 문자열의 길이를 얻을 수 있음
					}maxlength = Math.max(maxlength, 2*d-1);
					//2. 가로에서 길이가 짝수일때
					//(r,c)를 기준으로 오른쪽 문자와 확인
					//오른쪽 문자와 같으면 c+d+1과 c-d를 확인
					//같으면 d를 하나씩 늘림
					d=0;
					while(c+d+1<100&&c-d>=0&&arr[r][c+d+1]==arr[r][c-d]) {
						d++;
						//d는 문자열의 반이므로 문자열의 길이는 2*d
					}maxlength = Math.max(maxlength, 2*d);
					//3. 세로에서 길이가 홀수일때
					//가로일때와 동일
					d=0;
					while(r+d<100&&r-d>=0&&arr[r+d][c]==arr[r-d][c]) {
						d++;
					}maxlength = Math.max(maxlength, 2*d-1);
					//4. 세로에서 길이가 짝수일때
					//세로일때와 동일
					d=0;
					while(r+d+1<100&&r-d>=0&&arr[r+d+1][c]==arr[r-d][c]) {
						d++;
					}maxlength = Math.max(maxlength, 2*d);
				}
			}
			System.out.printf("#%d %d",t,maxlength);
			System.out.println();
			
			
		}
	}

}
