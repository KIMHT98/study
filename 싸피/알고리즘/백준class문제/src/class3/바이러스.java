package class3;

import java.util.Scanner;

public class 바이러스 {
	static int N,cnt;
	static boolean[] visit;
	static int[][] graph;
	static void dfs(int n) {
		visit[n] = true;
		cnt++;
		for(int i=1;i<=N;i++) {
			if(!visit[i]&&graph[n][i]==1) {
				dfs(i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		graph = new int[N+1][N+1];
		visit = new boolean[N+1];
		cnt = -1;
		for(int i=0;i<E;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b]=graph[b][a] = 1;
		}
		dfs(1);
		System.out.println(cnt);
		
	}

}
