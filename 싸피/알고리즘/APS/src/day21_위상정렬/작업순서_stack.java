package day21_위상정렬;

import java.util.Scanner;
import java.util.Stack;

public class 작업순서_stack {
	static int V,E;
	static int[] degree;
	static int[][] adj;
	static boolean[] visit;
	static Stack<Integer> stack;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t<=10;t++) {
			
		V = sc.nextInt();
		E = sc.nextInt();
		adj = new int[V+1][V+1];
		degree = new int[V+1];
		visit = new boolean[V+1];
		stack = new Stack<>();
		for(int i=0;i<E;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			adj[start][end] = 1;
			degree[end]++;
		}
		for(int i=1;i<V+1;i++) {
			if(degree[i]==0) {
				dfs(i);
			}
		}
		sb.append("#").append(t).append(" ");
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		sb.append("\n");

	}
		System.out.println(sb);
}
	
	static void dfs(int v) {
		visit[v] = true;
		for(int i=1;i<V+1;i++) {
			if(adj[v][i]==1&&!visit[i]) {
				dfs(i);
			}
		}
		stack.add(v);
	}
	
}
