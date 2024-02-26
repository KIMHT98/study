package class2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 좌표정렬하기2_11651 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for(int i=0;i<n;i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
//		for(int i=0;i<n;i++) {
//			int minidx = i;
//			for(int j=i+1;j<n;j++) {
//				if(arr[minidx][1]>arr[j][1]) {
//					minidx = j;
//				}else if(arr[minidx][1]==arr[j][1]) {
//					if(arr[minidx][0]>arr[j][0]) {
//						minidx = j;
//					}
//				}
//			}
//				int[] tmp = arr[i];
//				arr[i] = arr[minidx];
//				arr[minidx] = tmp;
//		}
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] ==o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1]-o2[1];
			}
			
		});
		for(int i =0 ;i<n;i++) {
			System.out.println(arr[i][0]+ " "+ arr[i][1]);
		}

	}
		
	

}
