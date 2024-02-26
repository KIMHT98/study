package class2;

import java.util.Scanner;

public class 체스판칠하기_1018 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next().toCharArray();
		}
		int min = 64;
		String l1 = "BWBWBWBW";
		String l2 = "WBWBWBWB";
		for (int r = 0; r <= n - 8; r++) {
			for (int c = 0; c <= m - 8; c++) {
				int cnt = 0;
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (i % 2 == 0) {
							if (arr[r + i][c + j] != l1.charAt(j))
								cnt++;
						} else {
							if (arr[r + i][c + j] != l2.charAt(j))
								cnt++;
						}
					}
				}
				min = Math.min(min, cnt);
				cnt = 0;
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (i % 2 == 0) {
							if (arr[r + i][c + j] != l2.charAt(j))
								cnt++;
						} else {
							if (arr[r + i][c + j] != l1.charAt(j))
								cnt++;
						}
					}
				}
				min = Math.min(min, cnt);

			}
		}
		System.out.println(min);
	}

}
