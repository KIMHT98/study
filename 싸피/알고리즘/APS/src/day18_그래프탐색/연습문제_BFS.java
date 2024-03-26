package day18_그래프탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연습문제_BFS {
	static int V;
	static boolean[] visit;
	static int[][] graph;
	
	static void BFS(int root) {
		Queue<Integer> q = new LinkedList<>();
		visit = new boolean[V+1];
		q.add(root);
		visit[root] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr+" ");
			for(int i=1;i<=V;i++) {
				if(!visit[i] && graph[curr][i] == 1) {
					visit[i] = true;
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		graph = new int[V+1][V+1];
		for(int i=0;i<E;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			graph[A][B] = graph[B][A] = 1;
		}
		BFS(1);
	}
}
