package day19_그래프비용;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 창용마을무리의개수_DFS {
	static List<Integer>[] adj;
	static int N, M;
	static boolean[] visit;
	
	static void dfs(int root) {
		visit[root]=true;
		for(int next: adj[root]) {
			if(!visit[next]) {
				dfs(next);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			M = sc.nextInt();
			
			//인접리스트
			adj = new ArrayList[N+1];
			
			for(int i=1;i<=N;i++) {
				adj[i] = new ArrayList<>();
			}
			//각 번호별 인접 번호 저장
			for (int i = 0; i < M; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				adj[A].add(B);
				adj[B].add(A);
			}
			int cnt = 0;//무리 개수
			visit = new boolean[N+1];//방문 배열
			for(int i=1;i<=N;i++) {
				if(!visit[i]) {
					dfs(i);
					cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}

}
