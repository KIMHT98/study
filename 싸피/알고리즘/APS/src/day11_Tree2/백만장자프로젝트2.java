package day11_Tree2;

import java.util.*;

public class 백만장자프로젝트2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n =sc.nextInt();
			int [] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			int max = 0;
			int[] maxarr = new int[n];
			for(int i=n-1;i>=0;i--) {
				max = Math.max(max, arr[i]);
				maxarr[i] = max;
			}
			long sum = 0;
			for(int i=0;i<n;i++) {
				sum += (maxarr[i] - arr[i]); 
			}
			System.out.println("#"+t+" "+sum);
		}
		
	}

}

