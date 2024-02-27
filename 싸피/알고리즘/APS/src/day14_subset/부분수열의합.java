package day14_subset;

import java.util.Scanner;

public class 부분수열의합 {
	static int n,k;
	static int[] a;
	static boolean[] sel;
	static int cnt, sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			n = sc.nextInt();
			k = sc.nextInt();
			a = new int[n];
			sel = new boolean[n];
			for(int i=0;i<n;i++) {
				a[i] = sc.nextInt();
			}
			sum=0;
			cnt =0;
			cSum(0);
			System.out.println("#"+t+" "+cnt);
		}
	}
	static void cSum(int idx) {
		if(idx>=n) {
			for(int i=0;i<n;i++) {
				if(sel[i]) {
					sum += a[i];
				}
			}
			if(sum==k) {
				cnt++;
			}
			sum=0;
			return;
		}
		sel[idx] = true;
		cSum(idx+1);
		sel[idx] = false;
		cSum(idx+1);
		
		
		
		
	}

}
