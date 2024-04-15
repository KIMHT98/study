package class3;

import java.util.Scanner;

public class IOIOI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String s = sc.next();
		int result = 0;
		int cnt = 0;
		for (int i = 1; i < m - 1; i++) {
			if (s.charAt(i) == 'O' && s.charAt(i - 1) == 'I' && s.charAt(i + 1) == 'I') {
				cnt++;
				if (cnt == n) {
					result++;
					cnt--;
				}
				i++;
			}else {
				cnt = 0;
			}
		}
		System.out.println(result);
	}

}
