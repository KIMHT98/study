package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 알파벳_1987 {
	static int N, M, ans;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	static void dfs(int r, int c, int cnt, Set<Character> alphabet) {
		ans = Math.max(ans, cnt);
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;
			if (alphabet.contains(map[nr][nc]))
				continue;
			alphabet.add(map[nr][nc]);
			dfs(nr,nc,cnt+1,alphabet);
			alphabet.remove(map[nr][nc]);

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		N = Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);
		map = new char[N][M];
		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
		}
		ans = 0;
		Set<Character> alphabet = new HashSet<>();
		alphabet.add(map[0][0]);
		dfs(0,0,1,alphabet);
		System.out.println(ans);

	}

}
