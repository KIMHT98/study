package day19_그래프비용;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 창용마을무리의개수_크루스칼 {
	static int N, M;
	static int[] p;

	static class Edge{
		int start, end;

		public Edge(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();// 정점의 개수
			M = sc.nextInt();// 간선의 개수

			// 간선
			Edge[] edges = new Edge[M];
			for (int i = 0; i < M; i++) {
				edges[i] = new Edge(sc.nextInt(), sc.nextInt());
			}
			// 상호 배타 집합 활용
			p = new int[N + 1];
			for (int i = 1; i < N + 1; i++) {
				p[i] = i;
			}
			int cnt = 1;// 무리 개수
			for (int i = 0; i < M; i++) {
				int px = findset(edges[i].start);
				int py = findset(edges[i].end);

				if (px != py) {
					union(px, py);
				}
			}
			List<Integer> moori = new ArrayList<>();
			for(int i=1;i<=N;i++) {
				if(moori.contains(findset(p[i])))continue;
				moori.add(findset(p[i]));
			}
			System.out.println(Arrays.toString(edges));
			System.out.println(Arrays.toString(p));
			System.out.println(moori);
			System.out.println("#" + t + " " + moori.size());
		}
	}

	private static void union(int px, int py) {
		if (px < py) {
			p[py] = px;
		} else {
			p[px] = py;
		}
	}

	static int findset(int x) {
		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}

}
