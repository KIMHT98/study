package day20_그래프비용2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 복제로봇_1944 {
	static boolean isT;
	static int N, M;
	static char[][] arr;
	static boolean[][] visit;
	static int[][] position, results;
	static int[] p, dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	static void bfs(int i, int r, int c) {
		isT = true;
		visit = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c, 0 });
		visit[r][c] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int k = 0; k <= M; k++) {
				if (curr[0] == position[k][0] && curr[1] == position[k][1]) {
					results[i][k] = curr[2];
				}
			}
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if (arr[nr][nc] == '1')
					continue;
				if (visit[nr][nc])
					continue;

				visit[nr][nc] = true;
				q.add(new int[] { nr, nc, curr[2] + 1 });
			}
		}

		for (int k = 1; k <= M; k++) {
			if (results[0][k] == 0) {
				isT = false;
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr1 = br.readLine().split(" ");
		N = Integer.parseInt(arr1[0]);
		M = Integer.parseInt(arr1[1]);
		arr = new char[N][N];
		position = new int[M + 1][2];
		results = new int[M + 1][M + 1];
		int idx = 1;
		for (int r = 0; r < N; r++) {
			arr[r] = br.readLine().toCharArray();
			for (int c = 0; c < N; c++) {
				if (arr[r][c] == 'S') {
					position[0] = new int[] { r, c };
				}
				if (arr[r][c] == 'K') {
					position[idx] = new int[] { r, c };
					idx++;
				}
			}
		}

		int pick = 0;
		for (int i = 0; i < M; i++) {
			bfs(i, position[i][0], position[i][1]);
		}

//		for (int[] c : results) {
//			System.out.println(Arrays.toString(c));
//		}
		if (!isT) {
			System.out.println(-1);
		} else {
			int ans = 0;
			p = new int[M + 1];
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[2] - o2[2];
				}
			});
			for (int i = 0; i < M; i++) {
				for (int j = i + 1; j <= M; j++) {
					pq.add(new int[] { i, j, results[i][j] });
				}
			}
			for (int i = 0; i <= M; i++) {
				p[i] = i;
			}
			int pqs = pq.size();
			for (int i = 0; i < pqs; i++) {
				int[] now = pq.poll();
				int px = findset(now[0]);
				int py = findset(now[1]);

				if (px != py) {
					union(px, py);
					ans += now[2];
					pick++;
				}
				if (pick == M)
					break;
			}
			System.out.println(ans);
		}

	}

	static void union(int x, int y) {
		// 연산량 줄이기 위한 방법
		p[Math.max(x, y)] = Math.min(x, y);
	}

	static int findset(int x) {

		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}

}
