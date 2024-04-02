package day20_그래프비용2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 최단경로_1753 {
	static int V, E, INF = Integer.MAX_VALUE;
	static int[] dist;
	static List<Node>[] adj;

	static class Node implements Comparable<Node> {
		int end, w;

		public Node(int end, int w) {
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] arr1 = br.readLine().split(" ");
		V = Integer.parseInt(arr1[0]);
		E = Integer.parseInt(arr1[1]);
		int start = Integer.parseInt(br.readLine());
		adj = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		dist = new int[V + 1];
		Arrays.fill(dist, INF);
		for (int i = 0; i < E; i++) {
			String[] arr2 = br.readLine().split(" ");
			int a = Integer.parseInt(arr2[0]);
			int b = Integer.parseInt(arr2[1]);
			int w = Integer.parseInt(arr2[2]);
			adj[a].add(new Node(b, w));
		}
		dijkstra(start);
		for (int i = 1; i <= V; i++) {
			if (dist[i] != INF)
				sb.append(dist[i]).append("\n");
			else
				sb.append("INF").append("\n");
		}
		System.out.println(sb);
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[V + 1];
		dist[start] = 0;
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (visit[curr.end])
				continue;
			visit[curr.end] = true;
			for (Node node : adj[curr.end]) {
				if (!visit[node.end] && dist[node.end] > dist[curr.end] + node.w) {
					dist[node.end] = dist[curr.end] + node.w;
					pq.add(new Node(node.end, dist[node.end]));
				}
			}
		}
	}

}
