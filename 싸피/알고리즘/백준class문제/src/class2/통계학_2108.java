package class2;

import java.util.Arrays;
import java.util.Scanner;

public class 통계학_2108 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		double total = 0;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		int[][] count = new int[4001][2];
		for(int i=0;i<n;i++) {
			if(arr[i]>=0) {
				count[arr[i]][0]++;
			}else {
				count[Math.abs(arr[i])][1]++;
			}
		}
		int max = 0;
		
		for(int i = 0;i<n;i++) {
			if(arr[i]>=0) {
				max = Math.max(max, count[arr[i]][0]);
			}else {
				max = Math.max(max, count[Math.abs(arr[i])][1]);
			}
		}
		int cnt = 0;
		for(int i = 0;i<4001;i++) {
			if(count[i][0]==max)cnt++;
			if(count[i][1]==max)cnt++;
		}
		int[] check = new int[cnt];
		int idx = 0;
		for(int i = 0;i<4001;i++) {
			if(count[i][0]==max) {
				check[idx]=i;
				idx++;
			}else if(count[i][1]==max) {
				check[idx] = -i;
				idx++;
			}
		}
		Arrays.sort(arr);
		Arrays.sort(check);
		//산술 평균
		System.out.println(Math.round(total/n));
		//중간값
		System.out.println(arr[n/2]);
		//최빈값
		System.out.println(cnt==1?check[0]:check[1]);
		//최대최소 차이
		System.out.println(arr[n-1]-arr[0]);
		
	}

}
