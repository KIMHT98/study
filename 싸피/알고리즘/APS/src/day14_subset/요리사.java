package day14_subset;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 요리사 {
	static int n, r, sumS;
	static int[][] S;
	static int[] sel;
	static int[] list;
	static List<Integer> synergy;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			r = n / 2;
			sel = new int[r];
			synergy = new ArrayList<>();
			S = new int[n][n];
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					S[r][c] = sc.nextInt();
				}
			}
			list = new int[n];
			for (int i = 0; i < n; i++) {
				list[i] = i;
			}
			comb(n, r);
			int minS = Integer.MAX_VALUE;
			for (int i = 0; i < synergy.size() / 2; i++) {
				minS = Math.min(minS, Math.abs(synergy.get(i) - synergy.get(synergy.size() - i - 1)));
			}
			System.out.println("#"+t+" "+minS);

		}
	}

	public static void comb(int n, int r) {
		sumS = 0;
		if (r == 0) {
			for (int i = 0; i < sel.length - 1; i++) {
				for (int j = i + 1; j < sel.length; j++) {
					sumS += S[sel[i]][sel[j]] + S[sel[j]][sel[i]];
				}
			}
			synergy.add(sumS);

		} else if (n < r)
			return;
		else {
			sel[r - 1] = list[n - 1];
			comb(n - 1, r - 1);
			comb(n - 1, r);

		}
	}

}
