package class3;

import java.util.Scanner;

public class 과일탕후루 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] count = new int[n+1];
		int[] tanghuru = new int[n];
		for(int i=0;i<n;i++) {
			int now = sc.nextInt();
			tanghuru[i] = now;
			count[now]++;
		}
		int cnt = 0;
		for(int i=1;i<=n;i++) {
			if(count[i]>0)cnt++;
		}
		
		
	}

}
