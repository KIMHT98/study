package day01_array;
import java.util.Arrays;
import java.util.Scanner;


public class swea_1984_중간평균값구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int[] arr = new int[10];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int i=0;i<10;i++) {
				arr[i] = sc.nextInt();
				if(arr[i]>max)
					max = arr[i];
				if(arr[i]<min)
					min = arr[i];
			}
			int sum = 0;
			int idx = 0;
			Arrays.sort(arr);
			for(int i=1;i<9;i++) {
					sum+=arr[i];
					idx ++;
			}
			double avg = (double)sum / idx;
			System.out.printf("#%d %.0f",t,avg);
			System.out.println();
			
		}

	}

}
