package class2;

import java.util.Scanner;

public class hashing_15829 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		String str = sc.next();
		long sum = str.charAt(0)-'a'+1;
		long c = 1;
		for(int i=1;i<l;i++) {
			c = c*31%1234567891;
			sum += ((str.charAt(i)-'a'+1)*c%1234567891);
		}
		System.out.println(sum%1234567891);

	}

}
