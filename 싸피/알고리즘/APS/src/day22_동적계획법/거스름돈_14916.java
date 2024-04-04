package day22_동적계획법;

import java.util.Scanner;

public class 거스름돈_14916 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		for(int i=1;i<=n;i++) {
			int minCnt = 50000;
			if(i>=2) {
				minCnt = Math.min(dp[i-2]+1, minCnt);
			}
			if(i>=5) {
				minCnt = Math.min(dp[i-5]+1, minCnt);
			}
			dp[i] = minCnt;
		}
		System.out.println(dp[n]==50000?-1:dp[n]);		
	}

}
