package day01_array;
import java.util.Scanner;


public class swea_2068_최대수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int[] arr = new int[10];
			for(int i = 0;i<10;i++) {
				arr[i] = sc.nextInt();
			}
			int max = Integer.MIN_VALUE;
			for(int i=0;i<10;i++) {
				if(arr[i]>max)
					max = arr[i];
			}
			
			System.out.printf("#%d %d",t,max);
			System.out.println();
		}

	}

}
