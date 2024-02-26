package 배열;

import java.util.Scanner;

public class boj1475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[]arr = new int[10];
		while(n>0) {
			arr[n%10]++;
			n/=10;
		}
		arr[6]+=arr[9];
		arr[9]=0;
		if(arr[6]%2==0)
			arr[6] /= 2;
		else
			arr[6] = arr[6]/2+1;
		int set = 0;
		for(int i=0;i<arr.length;i++) {
			set = Math.max(set, arr[i]);
		}
		System.out.println(set);
	}

}
