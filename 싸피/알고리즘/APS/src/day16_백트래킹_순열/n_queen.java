package day16_백트래킹_순열;

import java.util.Arrays;
import java.util.Scanner;

public class n_queen {
	static int n, cnt, sum;
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = i + 1;
			}
			result = new int[n];
			visited = new boolean[n];
			sum = 0;
			perm(0);
			System.out.println("#" + t + " " + sum);

		}

	}

	public static void perm(int idx) {
		if (idx == n) {
			boolean istrue = true;
			for (int j = 1; j < n; j++) {
				for (int i = j; i < n; i++) {
					int d = Math.abs(result[i] - result[i - j]);
					if (d == j) {
						istrue = false;
						break;
					}
				}
			}
			if (istrue) {
				sum++;
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
		
			result[idx] = arr[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}

}
