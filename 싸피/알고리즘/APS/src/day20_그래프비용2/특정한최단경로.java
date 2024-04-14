package day20_그래프비용2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 특정한최단경로 {
	static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}

	}

	static int[][] dist;
	static int N, E, INF = 2000000000;
	static List<Node>[] adj;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		dist = new int[3][N + 1];
		for (int i = 0; i < 3; i++) {
			Arrays.fill(dist[i], INF);
		}
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			adj[a].add(new Node(b, w));
			adj[b].add(new Node(a, w));
		}
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		dijskstra(1, 0);
		dijskstra(v1, 1);
		dijskstra(v2, 2);
//		for (int[] d : dist) {
//			System.out.println(Arrays.toString(d));
//		}
		long ans = Math.min(dist[0][v1] + dist[1][v2] + dist[2][N], dist[0][v2] + dist[2][v1] + dist[1][N]);
//		System.out.println(ans);
		if (E == 0) {
			ans = -1;
		} else if (ans>=INF||ans<0) {
			ans = -1;
		}
		System.out.println(ans);

	}

	static void dijskstra(int n, int i) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[N + 1];
		dist[i][n] = 0;
		pq.add(new Node(n, 0));
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			visit[curr.v] = true;
			for (Node node : adj[curr.v]) {
				if (!visit[node.v] && dist[i][node.v] > dist[i][curr.v] + node.w) {
					dist[i][node.v] = dist[i][curr.v] + node.w;
					pq.add(new Node(node.v, dist[i][node.v]));
				}
			}

		}
	}

}
