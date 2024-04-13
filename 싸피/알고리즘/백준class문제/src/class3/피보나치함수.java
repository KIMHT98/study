package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수 {
	static int cnt0,cnt1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			cnt0 = 0;
			cnt1 = 0;
			int[][] dp = new int[n+1][2];
			dp[0][0] = 1;
			dp[0][1] = 0;
			if(n>0) {
			dp[1][0] = 0;
			dp[1][1] = 1;
			}
			for(int i=2;i<=n;i++) {
				dp[i][0] = dp[i-2][0]+dp[i-1][0];
				dp[i][1] = dp[i-2][1]+dp[i-1][1];
			}
			System.out.println(dp[n][0]+" "+dp[n][1]);
		}
	}
}
