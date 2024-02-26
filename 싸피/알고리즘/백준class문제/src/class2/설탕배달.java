package class2;

import java.util.Scanner;

public class 설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int five = n / 5;
		int cnt = -1;
		if (n % 5 == 0) {
			cnt = n / 5;
		} else {
			while (five >= 0) {
				int three = (n - (five * 5)) / 3;
				if (five*5 + three*3 == n) {
					cnt = five + three;
					break;
				}else {
					five--;
				}
			}
		}
		System.out.println(cnt);
	}
}
