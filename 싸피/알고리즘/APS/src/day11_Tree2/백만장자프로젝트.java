package day11_Tree2;

import java.util.*;

public class 백만장자프로젝트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n =sc.nextInt();
			int [] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			long sum = 0;
			int max = 0;
			int maxidx = 0;
			for(int i=0;i<n;i++) {
				if(arr[i]>max) {
					max = arr[i];
					maxidx = i;
				}
			}
			int startidx = 0;
			while(true) {
			if(maxidx == n-1) {
				for(int i=startidx;i<=maxidx;i++) {
					sum+= max - arr[i];
				}
				System.out.println("#"+t+" "+sum);
				break;
			}else {
				for(int i=startidx;i<=maxidx;i++) {
					sum+= max - arr[i];
				}
				max = 0;
				startidx = maxidx+1;
				for(int i=startidx;i<n;i++) {
					if(arr[i]>max) {
						max = arr[i];
						maxidx = i;
					}
				}
			}
			}
		}
		
	}
//	static long result(int[] arr) {
//		long sum = 0;
//		int max = 0;
//		int maxidx = 0;
//		int n = arr.length;
//		for(int i=0;i<n;i++) {
//			if(arr[i]>max) {
//				max = arr[i];
//				maxidx = i;
//			}
//		}
//		int startidx;
//		if(maxidx == n-1) {
//			for(int i=startidx;i<=maxidx;i++) {
//				sum+= max - arr[i];
//			}
//			return sum;
//	}else {
//		
//	}
//
//}
}

