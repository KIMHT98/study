package day1_array;
import java.util.Scanner;


public class swea1206_빌딩조망권 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			int sum = 0;
			for(int i=2;i<N-2;i++) {
				if(arr[i]-arr[i-1]>0&arr[i]-arr[i-2]>0&arr[i]-arr[i+1]>0&arr[i]-arr[i+2]>0) {
					sum += Math.min(Math.min(arr[i]-arr[i-1],arr[i]-arr[i-2]),Math.min(arr[i]-arr[i+1],arr[i]-arr[i+2]));
					
				}
			}
			System.out.printf("#%d %d",t,sum);
			System.out.println();
		}

	}

}
