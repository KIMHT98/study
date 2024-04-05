package A형대비;

import java.util.Scanner;

public class 디저트카페 {
	static int N;
	static int[][] cafe;
	static int[] dr = {1,1,-1,-1}, dc = {-1,1,1,-1};
	 
//	static int search(int r, int c) {
//		int[] count = new int[101];
//		count[cafe[r][c]]++;
//		for(int i=0;i<4;i++) {
//			while(r>=0&&r<N&&c>=0&&c<N) {
//			
//		}
//			
//		}
//	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			cafe = new int[N][N];
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					cafe[r][c] = sc.nextInt();
				}
			}
			
		}
	}

}
