package day22_동적계획법;

import java.util.Arrays;
import java.util.Scanner;

public class 이동하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N+1][M+1];
		int[][] dp = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dp[1][1]=arr[1][1];
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=M;c++) {
				if(r>1&&c==1) {
					dp[r][c] =(arr[r][c]+ dp[r-1][c]);
				}
				else if(r==1&&c>1) {
					dp[r][c] =(arr[r][c] + dp[r][c-1]);
				}
				else {
					dp[r][c] =arr[r][c]+ Math.max(dp[r-1][c],dp[r][c-1] ); 
				}
			}
		}
//		for(int[] a:dp) {
//			
//			System.out.println(Arrays.toString(a));
//		}
		System.out.println(dp[N][M]);
	}
}
