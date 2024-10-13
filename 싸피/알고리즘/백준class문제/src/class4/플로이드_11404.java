package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 플로이드_11404 {
	static class Node implements Comparable<Node>{
		int end, value;
		Node(int end, int value){
			this.end = end;
			this.value = value;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.value, o.value);
		}
		
	}
	static ArrayList<Node>[] adj;
	static int n,m;
	static int INF = Integer.MAX_VALUE/2;
	static int[][] dist;
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq= new PriorityQueue<>();
		boolean[] visit = new boolean[n+1];
		dist[start][start] = 0;
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(visit[curr.end])continue;
			visit[curr.end] = true;
			for(Node node : adj[curr.end]) {
				if(!visit[node.end]&& dist[start][node.end]>dist[start][curr.end]+node.value) {
					dist[start][node.end] = dist[start][curr.end]+node.value;
					pq.add(new Node(node.end,dist[start][node.end]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		adj = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			adj[i] = new ArrayList<>();
		}
		dist = new int[n+1][n+1];
		for(int[] arr : dist) {
			Arrays.fill(arr,INF);
		}
		for(int i=0;i<m;i++) {
			String[] arr = br.readLine().split(" ");
			int start = Integer.parseInt(arr[0]);
			int end = Integer.parseInt(arr[1]);
			int value = Integer.parseInt(arr[2]);
			adj[start].add(new Node(end,value));
		}
		for(int i=1;i<=n;i++) {
			dijkstra(i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				  if (dist[i][j] == INF) {
	                    sb.append("0 ");
	                } else {
	                    sb.append(dist[i][j]).append(" ");
	                }
	            }
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
