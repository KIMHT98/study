package class4;

import java.util.Scanner;

public class 스티커_9465 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			
		int n = sc.nextInt();
		int[][] arr = new int[2][n];
		int[][] dp = new int[2][n];
		for(int r=0;r<2;r++) {
			for(int c=0;c<n;c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		dp[0][0] = arr[0][0];
		dp[1][0] = arr[1][0];
		if(n>1) {
			dp[0][1] = arr[1][0]+arr[0][1];
			dp[1][1] = arr[0][0]+arr[1][1];
		}
		for(int c=2;c<n;c++) {
			dp[0][c] = Math.max(dp[1][c-1],dp[1][c-2])+arr[0][c];
			dp[1][c] = Math.max(dp[0][c-1], dp[0][c-2])+arr[1][c];
		}
		System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
	}
	}

}
