package class3;

import java.util.Scanner;

public class 카잉달력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int ans = 0;
			if (N == M) {
				if (x != y)
					ans = -1;
				else
					ans = x;
			} else if (N > M) {
				if (x == y)
					ans = x;
				else if (x > y) {
					if ((x - y) % (N - M) != 0)
						ans = -1;
					else {
						ans = (x - y) / (N - M) * N + y;
					}
				} else {
					if ((M + x - y) % (N - M) != 0)
						ans = -1;
					else {
						ans = (M + x - y) / (N - M) * N + y;
					}
				}

			} else {
				if (x == y)
					ans = y;
				else if (x > y) {
					if ((N + y - x) % (M - N) != 0)
						ans = -1;
					else {
						ans = (N + y - x) / (M - N) * M + x;
					}

				}else {
					if ((y - x) % (M - N) != 0)
						ans = -1;
					else {
						ans = (y - x) / (M - N) * M + x;
					}
				}
			}
			System.out.println(ans);
		}
	}
}
