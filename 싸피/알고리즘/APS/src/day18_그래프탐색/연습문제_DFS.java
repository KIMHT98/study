package day18_그래프탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 연습문제_DFS {
	static int V;
	static boolean[] visit;
	static List<Integer>[] adj;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		visit = new boolean[V+1];
		adj = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adj[A].add(B);
			adj[B].add(A);
		}
		for(List l:adj) {
			System.out.println(l);
		}
		DFS(1);
	}
	static void DFS(int root) {
//		visit[root] = true;
//		System.out.print(root+ " ");
//		for(int i=1;i<=V;i++) {
//			if(!visit[i]) {
//				DFS(i);
//			}
//		}
		Stack<Integer> s = new Stack<>();
		s.push(root);
		visit[root] = true;
		while(! s.isEmpty()) {
			int curr = s.pop();
			System.out.print(curr+" ");
			for(int w:adj[curr]) {
				if(!visit[w]) {
					s.push(w);
					visit[w] = true;
				}
			}
		}
	}

}
