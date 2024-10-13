package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구간함구하기5_11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		int[][] dp = new int[n+1][n+1];
		for(int r=1;r<=n;r++) {
			String[] arr1 = br.readLine().split(" ");
			for(int c=1;c<=n;c++) {
				dp[r][c] = dp[r][c-1]+Integer.parseInt(arr1[c-1]);
			}
		}
		for(int i=0;i<m;i++) {
			int ans = 0;
			String[] arr2 = br.readLine().split(" ");
			int x1 = Integer.parseInt(arr2[0]);
			int y1 = Integer.parseInt(arr2[1]);
			int x2 = Integer.parseInt(arr2[2]);
			int y2 = Integer.parseInt(arr2[3]);
			for(int x=x1;x<=x2;x++) {
				ans+= (dp[x][y2]-dp[x][y1-1]);
			}
			sb.append(ans).append("\n");
			
		}
		System.out.println(sb);
	}

}
