package day20_그래프비용2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 최소비용구하기_1916 {
	static class Node implements Comparable<Node> {
		int end, w;

		public Node(int end, int w) {
			super();
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
	}

	static int INF = Integer.MAX_VALUE;
	static int N, M,cnt;
	static List<Node>[] adj;
	static int[] dist,p;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		dist = new int[N + 1];
		p = new int[N+1];
		Arrays.fill(dist, INF);

		for (int i = 0; i < M; i++) {
			String[] arr = br.readLine().split(" ");
			int start = Integer.parseInt(arr[0]);
			int end = Integer.parseInt(arr[1]);
			int w = Integer.parseInt(arr[2]);
			adj[start].add(new Node(end, w));
		}
		String[] arr2 = br.readLine().split(" ");
		int s = Integer.parseInt(arr2[0]);
		int e = Integer.parseInt(arr2[1]);
		dijkstra(s, e);
		System.out.println(dist[e]);
		cnt=1;
		printPath(s, e);
		System.out.println(sb.length()/2);
		System.out.println(sb);

	}

	static void dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[N + 1];
		dist[start] = 0;
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (curr.end == end) {
				return;
			}
			
			if (visit[curr.end])
				continue;
			visit[curr.end] = true;
			for (Node node : adj[curr.end]) {
				if (!visit[node.end]) {
					if (dist[node.end] > dist[curr.end] + node.w) {
						dist[node.end] = dist[curr.end] + node.w;
						pq.add(new Node(node.end, dist[node.end]));
						p[node.end] = curr.end;
					}
				}
			}
		}
	}
	  static void printPath(int start, int end) {
	        if (end == start) {
	            sb.insert(0, end + " ");
	            return;
	        }
	        printPath(start, p[end]);
	        sb.append(end).append(" ");
	    }
	
}
