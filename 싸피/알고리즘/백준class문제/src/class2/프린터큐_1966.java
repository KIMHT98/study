package class2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 프린터큐_1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			Queue<int[]> q = new LinkedList<>();
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] arr = new int[n][2];
			for (int i = 0; i < n; i++) {
				arr[i][0] = i;
				arr[i][1] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				q.offer(arr[i]);
			}
			int num = -1;
			int cnt = 0;
			while (num != m) {
				if (isMax(q, q.peek()[1])) {
					if (q.peek()[0] == m) {
						num = q.poll()[0];
						cnt++;
						System.out.println(cnt);
					} else {
						q.poll();
						cnt++;
					}
				} else {
					q.add(q.poll());
				}
			}
		}

	}

	static boolean isMax(Queue<int[]> q, int n) {
		int max = -1;
		for (int i = 0; i < q.size(); i++) {
			max = Math.max(max, q.peek()[1]);
			q.add(q.poll());
		}
		if (max == n)
			return true;
		return false;

	}
}
