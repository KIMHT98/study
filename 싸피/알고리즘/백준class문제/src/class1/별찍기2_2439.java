package class1;

import java.util.Scanner;

public class 별찍기2_2439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1;i<=n;i++) {
			String str = "";
			for(int j = 1;j<=n-i;j++) {
				str += " ";
			}
			for(int j = 1;j<=i;j++) {
				str+="*";
			}
			System.out.println(str);
		}
	}

}
