package day21_위상정렬;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 작업순서_queue {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	StringBuilder sb = new StringBuilder();
	for(int t=1;t<=10;t++) {
		sb.append("#").append(t).append(" ");
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[] degree = new int[V+1];
		int[][] adj = new int[V+1][V+1];
		for(int i=0;i<E;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			adj[start][end] = 1;
			degree[end]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<V+1;i++) {
			if(degree[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");
			for(int i=1;i<V+1;i++) {
				if(adj[curr][i]==1) {
					degree[i]--;
					adj[curr][i]=0;
					if(degree[i] == 0) {
						q.add(i);
					}
				}
			}
		}
		sb.append("\n");
	}
	System.out.println(sb);
	
	}
}
