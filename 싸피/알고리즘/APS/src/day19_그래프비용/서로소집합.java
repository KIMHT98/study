package day19_그래프비용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서로소집합 {
	static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			String ans = "#" + t + " ";
			p = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				p[i] = i;
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(bf.readLine());
				int method = Integer.parseInt(st.nextToken());
				int a = findset(Integer.parseInt(st.nextToken()));
				int b = findset(Integer.parseInt(st.nextToken()));
				if (method == 0) {
					if (a != b)
						union(a, b);
				} else {
					if (check(a, b))
						ans += 1;
					else
						ans += 0;
				}
			}
			System.out.println(ans);

		}
	}

	static void union(int a, int b) {
		p[Math.max(a, b)] = Math.min(a, b);
	}

	static int findset(int x) {
		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}

	static boolean check(int a, int b) {
		return a == b;
	}

}
