package day22_동적계획법;

import java.util.Scanner;

public class 타일링2xn_11726 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n + 1];
		dp[1] = 1;
		if (n >= 2) {
			dp[2] = 2;
			for (int i = 3; i <= n; i++) {
				dp[i] = dp[i - 1] % 10007 + dp[i - 2] % 10007;
			}
		}
		System.out.println(dp[n]%10007);

	}

}
