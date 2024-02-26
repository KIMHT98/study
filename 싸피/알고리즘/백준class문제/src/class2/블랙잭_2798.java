package class2;

import java.util.Scanner;

public class 블랙잭_2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int t=0;t<n;t++) {
			arr[t] = sc.nextInt();
		}
		int sum = 0;
		int max = 0;
		for(int i=0;i<n-2;i++) {
			for(int j=i+1;j<n-1;j++) {
				for(int k=j+1;k<n;k++) {
					sum += arr[i]+arr[j]+arr[k];
//					System.out.println(sum);
					if(sum>m) {
						sum = 0;
						continue;
					}else {
						max = Math.max(max, sum);
						sum=0;
					}
				}
			}
		}
		System.out.println(max);
	}

}
