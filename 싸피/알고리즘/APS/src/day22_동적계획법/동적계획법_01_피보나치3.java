package day22_동적계획법;

import java.util.Scanner;


public class 동적계획법_01_피보나치3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//10
		System.out.println(fibo3(N));//55
	}
	static int fibo3(int n) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-2]+dp[i-1];
		}
		return dp[n];
	}

}
