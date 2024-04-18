package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int K = Integer.parseInt(arr[1]);
		int[] coins = new int[N];
		for(int i=0;i<N;i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		for(int i=N-1;i>=0;i--) {
			if(K/coins[i]>0) {
				cnt+= K/coins[i];
				K -= (coins[i]*(K/coins[i]));
			}
			if(K==0)break;
		}
		System.out.println(cnt);
		
	}
}
