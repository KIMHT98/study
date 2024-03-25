package day17_그래프기본;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 작업순서 {
	static int V;
	static int[][] graph;
	static void bfs(int root,int[] arr) {
		boolean[] visit = new boolean[V + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(root);
		visit[root] = true;
		while (!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr + " ");
			for (int next = 1; next <= V; next++) {
				if (!visit[next] && graph[curr][next] != 0) {
					arr[next]--;
					if(arr[next]==0) {
						visit[next]=true;
						q.add(next);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			V = sc.nextInt();
			int E = sc.nextInt();
			graph = new int[V + 1][V + 1];
			int[] count = new int[V + 1];
			for (int i = 0; i < E; i++) {
				int p = sc.nextInt();
				int q = sc.nextInt();
				graph[p][q] = 1;
				count[q]++;
			}
			System.out.print("#"+t+" ");
			int[] arr = Arrays.copyOf(count, V+1);
			for (int i = 1; i <= V; i++) {
				if (count[i] == 0) {
					bfs(i,arr);
				}
			}
			System.out.println();
		}
	}
}
