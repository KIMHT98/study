package class4;

import java.util.Scanner;

public class 가장긴증가하는부분수열_11053 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dp=new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int ans = 1;
		for(int i=0;i<n;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);

	}

}
