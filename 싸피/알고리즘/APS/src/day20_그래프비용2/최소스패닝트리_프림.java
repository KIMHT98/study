package day20_그래프비용2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 최소스패닝트리_프림 {
	static final int INF = Integer.MAX_VALUE;
	static class Edge implements Comparable<Edge>{
		int a,b,w;

		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] arr1 = br.readLine().split(" ");
		int V = Integer.parseInt(arr1[0]);
		int E = Integer.parseInt(arr1[1]);
		
		List<Edge>[] adj = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			String[] arr2 = br.readLine().split(" ");
			int A = Integer.parseInt(arr2[0]);
			int B = Integer.parseInt(arr2[1]);
			int W = Integer.parseInt(arr2[2]);
			
			adj[A].add(new Edge(A,B,W));
			adj[B].add(new Edge(B,A,W));
			
		}
		
		boolean[] visit = new boolean[V+1];
		PriorityQueue< Edge>pq = new PriorityQueue<>();
		visit[1] = true;
		
		for(int i=0;i<adj[1].size();i++) {
			pq.add(adj[1].get(i));
		}

		int pick = 1;
		int ans = 0;
		while(pick!=V) {
			Edge e = pq.poll();
			if(visit[e.b]) continue;
			
			ans+=e.w;
			visit[e.b] = true;
			pick++;
			pq.addAll(adj[e.b]);
		}
		sb.append(ans);
		System.out.println(sb);

	}
	
}
