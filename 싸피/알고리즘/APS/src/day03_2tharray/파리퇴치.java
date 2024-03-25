package day03_2tharray;
import java.util.Scanner;


public class 파리퇴치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			//파리 존재 2차원 배열 생성
			int[][] arr = new int[N][N];
			for(int r = 0 ; r<N;r++) {
				for(int c=0;c<N;c++) {
					arr[r][c] =sc.nextInt();
				}
			}
			int max = 0;
			//파리채가 MXM크기니깐 arr을 순회할때 0~N-M까지만 순회
			for(int r=0;r<=N-M;r++) {
				for(int c=0;c<=N-M;c++) {
					int sum = 0;
					//파리채 2차원 배열
					int[][] dead = new int[M][M];
					for(int i=0;i<M;i++) {
						for(int j = 0;j<M;j++) {
							//파리채 요소는 arr[r][c]~arr[r+M-1][c+M-1]
							dead[i][j] = arr[r+i][c+j];
						}
					}
					for(int i=0;i<M;i++) {
						for(int j = 0;j<M;j++) {
							sum += dead[i][j];
						}
					}
					if(sum > max)
						max = sum;
				}
			}
			System.out.printf("#%d %d",t,max);
			System.out.println();
		}
	}

}
