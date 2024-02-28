package day_15_분할정복;

import java.util.Scanner;

public class 거듭제곱 {

	static int tc,n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			tc = sc.nextInt();
			n = sc.nextInt();
			m = sc.nextInt();
			System.out.println("#"+t+" "+power(n,m));
		}
	}
	static int power(int n, int m) {
		if(m==0)return 1;
		int tmp = power(n,m/2);
		if(m%2==0) {
			return tmp*tmp;
		}else {
			return tmp*tmp*n;
		}
	}

}
