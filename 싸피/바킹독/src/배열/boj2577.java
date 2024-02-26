package 배열;

import java.util.Scanner;

public class boj2577 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int multiple = A*B*C;
		int[]arr = new int[10];
		while(multiple>0) {
			arr[multiple%10]++;
			multiple/=10;
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
	

