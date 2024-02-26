package class2;

import java.math.BigInteger;
import java.util.Scanner;

public class 팩토리얼0의개수_1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		while(n>0) {
			cnt += (n/5);
			n/=5;
		}
		System.out.println(cnt);

	}

}
