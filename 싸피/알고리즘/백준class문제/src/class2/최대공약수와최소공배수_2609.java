package class2;

import java.util.Scanner;

public class 최대공약수와최소공배수_2609 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int gcd = 1;
		for (int i = Math.min(a, b); i >= 1; i--) {
			if (a % i == 0 && b % i == 0) {
				gcd = i;
				break;
			}
		}
		int lcm = (a/gcd) * (b/gcd) * gcd;
		System.out.println(gcd);
		System.out.println(lcm);

	}
}
