package day20_그래프비용2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 파티_1238 {
	static int N,M,X,max,INF = Integer.MAX_VALUE;
	static List<Node>[] adj;
	static int[][] dist;
	
	static class Node implements Comparable<Node>{
		int end, w;

		public Node(int end, int w) {
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
	}
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[N+1];
		dist[start][start] = 0;
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(visit[curr.end]) continue;
			visit[curr.end] = true;
			for(Node node : adj[curr.end]) {
				if(!visit[node.end]&&dist[start][node.end]>dist[start][curr.end]+node.w) {
					dist[start][node.end] = dist[start][curr.end]+node.w;
					pq.add(new Node(node.end,dist[start][node.end]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr1 = br.readLine().split(" ");
		N = Integer.parseInt(arr1[0]);
		M = Integer.parseInt(arr1[1]);
		X = Integer.parseInt(arr1[2]);
		adj = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		dist = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			Arrays.fill(dist[i], INF);
		}
		for(int i=0;i<M;i++) {
			String[] arr2 = br.readLine().split(" ");
			int a = Integer.parseInt(arr2[0]);
			int b = Integer.parseInt(arr2[1]);
			int w = Integer.parseInt(arr2[2]);
			adj[a].add(new Node(b,w));
		}
		for(int i=1;i<=N;i++) {
			dijkstra(i);
		}
		max = 0;
		for(int i=1;i<=N;i++) {
			max = Math.max(dist[i][X]+dist[X][i], max);
		}
		System.out.println(max);
		
	}

}
