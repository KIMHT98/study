package day20_그래프비용2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class contact {
	static int E, V, max;
	static List<Integer>[] adj;
	static List<Integer> queues;

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[V + 1];
		q.add(start);
		visit[start] = true;
		while (!q.isEmpty()) {
			queues = new ArrayList<>();
			int s = q.size();
			for (int i = 0; i < s; i++) {
				int curr = q.poll();
				queues.add(curr);
//				System.out.println(curr);
				max = Math.max(max, curr);
				for (int w : adj[curr]) {
					if (!visit[w]) {
						q.add(w);
						visit[w] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			V = 100;
			E = sc.nextInt() / 2;
			int start = sc.nextInt();
			adj = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				adj[from].add(to);
			}
			max = 0;
			bfs(start);
			Collections.sort(queues);
			System.out.println("#" + t + " " + queues.get(queues.size()-1));
		}

	}

}
