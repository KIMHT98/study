package class3;

import java.util.Scanner;

public class 나무자르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] trees = new int[N];
		int maxtree = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			trees[i] = sc.nextInt();
			maxtree = Math.max(maxtree, trees[i]);
		}
		int left = 0;
		int right = maxtree;
		int mid = 0;
		int result = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			long cut = 0;
			for (int i = 0; i < N; i++) {
				cut += ((trees[i] - mid) < 0 ? 0 : (trees[i] - mid));
			}
			if (cut >= M) {
				left = mid + 1;
				result = mid;
			} else if (cut < M)
				right = mid - 1;
		}

		System.out.println(result);
	}

}
