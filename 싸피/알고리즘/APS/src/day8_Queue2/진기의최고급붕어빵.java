package day8_Queue2;
import java.util.Arrays;
import java.util.Scanner;

public class 진기의최고급붕어빵 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		for(int x =1;x<=X;x++) {
			String result = "Possible";
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			int maxSec = arr[n-1];
			for(int i=0;i<n;i++) {
				if((i/k+1)*m>arr[i]) {
					result = "Impossible";
					break;
				}
			}
			
			System.out.printf("#%d %s",x,result);
			System.out.println();
		}
	}

}
