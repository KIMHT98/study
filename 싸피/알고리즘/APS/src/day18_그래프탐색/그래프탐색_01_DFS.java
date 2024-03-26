package day18_그래프탐색;

import java.util.Scanner;

public class 그래프탐색_01_DFS {
	static int V; // 정점의 수
	static int[][] adj; // 인접행렬
	static boolean[] visited; // 방문체크

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		int E = sc.nextInt();

		adj = new int[V + 1][V + 1]; // 시작점이 1번부터 시작
		visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adj[A][B] = adj[B][A] = 1; // 인접행렬 간선 정보 입력
		}

	}

	public static void DFS(int v) {
		// v 방문 처리
		visited[v] = true;
		System.out.println(v);

		// 인접한 친구들 방문(인접행렬, 인접리스트)
		for (int i = 1; i <= V; i++) {
			if (!visited[i] && adj[v][i] == 1)
				DFS(i);
		}
	}
	// 인접리스트 사용시
	/*
	 * for(int w: adj[v]){ if(!visited[i])} DFS(w); } 
	 */

}
