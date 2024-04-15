package class3;

import java.util.Scanner;

public class IOIOI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String s = sc.next();
		String P = "I";
		for(int i=0;i<n;i++) {
			P+="OI";
		}
		System.out.println(P);
	}

}
