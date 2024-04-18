package class3;

import java.util.Arrays;
import java.util.Scanner;

public class 파도반수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			long[] dp = new long[n+1];
			dp[1] = 1;
			if(n>1) {
				dp[2] = 1;
			}
			if(n>2) {
				dp[3] = 1;
			}
			if(n>3) {
				dp[4] = 2;
				for(int i=5;i<=n;i++) {
					dp[i] = dp[i-1]+dp[i-5];
				}
			}
			System.out.println(dp[n]);
		}
	}

}
