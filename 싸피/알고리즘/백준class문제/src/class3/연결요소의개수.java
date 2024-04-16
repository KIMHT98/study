package class3;

import java.util.Scanner;

public class 연결요소의개수 {
	static int N;
	static int[][] graph;
	static boolean[] visit;
	static void dfs(int num) {
		visit[num] = true;
//		System.out.print(num+" ");
		for(int i=1;i<=N;i++) {
			if(!visit[i]&&graph[num][i]==1) {
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		graph = new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = graph[b][a] = 1;
		}
		int cnt = 0;
		visit = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			if(!visit[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
