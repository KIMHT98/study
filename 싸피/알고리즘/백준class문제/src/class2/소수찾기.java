package class2;

import java.util.Scanner;

public class 소수찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for(int i=0;i<n;i++) {
			int m = sc.nextInt();
			boolean isPrime = true;
			if(m==1) {
				isPrime = false;
			}
			for(int j=2;j<=Math.sqrt(m);j++) {
				if(m%j==0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
