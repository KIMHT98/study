package class3;

import java.util.Scanner;

public class 경로찾기 {
	static boolean[] visit;
	static int N;
	static int[][] result,graph;
	
	static void dfs(int num,int root) {
		for(int i=0;i<N;i++) {
			if(!visit[i]&&graph[num][i]==1) {
				visit[i] = true;
				result[root][i] = 1;
				dfs(i,root);
			}
		}
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		graph = new int[N][N];
		result = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<N;i++) {
			visit = new boolean[N];
			dfs(i,i);
		}
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				sb.append(result[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
