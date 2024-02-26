package class2;

import java.util.Scanner;

public class 이항계수1_11050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(factorial(n)/(factorial(k)*factorial(n-k)));
	}
	public static int factorial(int n) {
		if(n<=1) {
			return 1;
		}else {
			return n*factorial(n-1);
		}
	}

}
