package class1;

import java.util.Scanner;

public class 문자열반복_2675 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			String str = sc.next();
			for(int i=0;i<str.length();i++) {
				for(int j=0;j<n;j++) {
					System.out.print(str.charAt(i));
				}
			}
			System.out.println();
		}

	}

}
