package class3;

import java.util.Scanner;

public class 과일탕후루 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] count = new int[10];
		int[] tanghuru = new int[n];
		for(int i=0;i<n;i++) {
			int now = sc.nextInt();
			tanghuru[i] = now;
		}
		int cnt = 0;
		int l = 0;
		int ans  = 0;
		
		for(int r = 0; r< n;r++) {
			if(count[tanghuru[r]]==0) {
				cnt++;
			}
			count[tanghuru[r]]++;
			while(cnt>2) {
				count[tanghuru[l]]--;
				if(count[tanghuru[l]]==0) {
					cnt --;
				}
				l++;
			}
			ans = Math.max(ans, r-l+1);
		}
		System.out.println(ans);
			
	}

}
