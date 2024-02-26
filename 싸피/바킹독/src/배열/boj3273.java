package 배열;

import java.util.Arrays;
import java.util.Scanner;

public class boj3273 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[]arr = new int[sc.nextInt()];
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		int x = sc.nextInt();
		Arrays.sort(arr);
		int cnt = 0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j = i+1;j<arr.length;j++) {
				if(arr[i]+arr[j]==x) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);

	}

}
