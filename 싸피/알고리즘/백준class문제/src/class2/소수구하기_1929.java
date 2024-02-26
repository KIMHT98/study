package class2;

import java.util.Arrays;
import java.util.Scanner;

public class 소수구하기_1929 {
	static boolean isPrime(int n) {
		boolean result = true;
		if(n==1)
			result = false;
		else {
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0) {
				result = false;
				break;
			}
		}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
//		boolean[] arr = new boolean[m+1];
//		Arrays.fill(arr,true);
//		arr[0] =false;
//		arr[1] = false;
//		int i =2;
//		while(i<m+1) {
//			if(!arr[i]) {
//				i++;
//				continue;
//			}
//			int c = 2;
//			while(i*c<m+1) {
//				arr[i*c++]=false;
//			}
//			i++;
//		
//		}
		for(int k=n;k<=m;k++) {
			if(isPrime(k)) {
				System.out.println(k);
			}
		}
	}

}