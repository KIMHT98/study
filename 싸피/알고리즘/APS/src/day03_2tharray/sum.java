package day03_2tharray;
import java.util.Scanner;


public class sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int T = sc.nextInt();
			int[][]arr = new int[100][100];
			int max = 0;
			//2차원 배열 생성
			for(int r=0;r<100;r++) {
				for(int c=0;c<100;c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			//행 우선 순회를 이용하여 각 행의 합 구하기
			for(int r=0;r<100;r++) {
				int sum = 0;
				for (int c =0;c<100;c++) {
					sum += arr[r][c];
				}
				if(sum>max)
					max = sum;
			}
			//열 우선 순회를 이용하여 각 열의 합을 구한다.
			for(int c=0;c<100;c++) {
				int sum = 0;
				for (int r =0;r<100;r++) {
					sum += arr[r][c];
				}
				if(sum>max)
					max = sum;
			}
			//대각선 순회를 이용해서 대각선의 합 구하기(\방향)
			for(int r = 0; r<100;r++) {
				int sum = 0;
				sum += arr[r][r];
				if(sum>max)
					max = sum;
			}
			//대각선 순회를 이용해서 대각선의 합 구하기(/방향)
			for(int r=99;r>=0;r--) {
				int sum = 0;
				sum += arr[r][99-r];
				if(sum>max)
					max = sum;
			}
			
			System.out.printf("#%d %d",t,max);
			System.out.println();
			
		}
	}

}
//입출력 값을 잘보자!
