package A형대비;

import java.util.Scanner;

public class 디저트카페 {
	static int N, max, srow, scol;
	static int[][] cafe;
	static int[] count;
	static boolean[] visit;
	static int[] dr = { 1, 1, -1, -1 }, dc = { -1, 1, 1, -1 };// 좌하 우하 우상 좌상

	static void dfs(int r, int c, int prevR, int prevC, int cnt, int dir) {
		for (int i = dir; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			if (nr == prevR && nc == prevC)
				continue;
			if (nr == srow && nc == scol) {
				max = Math.max(max, cnt + 1);
				return;
			}
			if (count[cafe[nr][nc]]==1)
				continue;
			count[cafe[nr][nc]]++;
			dfs(nr, nc, r, c, cnt + 1, i);
			count[cafe[nr][nc]]--;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			cafe = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					cafe[r][c] = sc.nextInt();
				}
			}
			max = -1;
			for (int r = 0; r < N - 2; r++) {
				for (int c = 1; c < N - 1; c++) {
					count = new int[101];
					count[cafe[r][c]]++;
					srow = r;
					scol = c;
					dfs(srow,scol,-1,-1,0,0);
				}
			}
			System.out.println("#" + t + " " + max);

		}
	}

}
