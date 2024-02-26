package day6_stack2;
import java.util.Scanner;

public class 거듭제곱 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int T = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println("#"+t+" "+power(n,m));
		}
	}
	public static long power(int n, int m) {
		if(m==0) return 1;
		return n * power(n, m-1);
	}

}
