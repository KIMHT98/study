package day2_array;
import java.util.Arrays;
import java.util.Scanner;


public class swea1208_flatten {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int dump = sc.nextInt();
			int[] arr = new int[100];
			for(int i=0;i<100;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			for(int i=0;i<dump;i++) {
				if(arr[99]==arr[0])
					break;
				else {
				arr[99]--;
				arr[0]++;
				Arrays.sort(arr);
				
			}
			}
			System.out.printf("#%d %d",t,arr[99]-arr[0]);
			System.out.println();
	}

}
}
