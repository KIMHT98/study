package day19_그래프비용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 네트워크연결 {
	static int[] p;
	static class Edge implements Comparable<Edge>{
		int s, e, w;

		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Edge[] edges = new Edge[M];
		for(int i=0;i<M;i++) {
			String[] str = br.readLine().split(" ");
			edges[i] = new Edge(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2]));
		}
		Arrays.sort(edges);
		p = new int[N+1];
		for(int i=1;i<=N;i++) {
			p[i] = i;
		}
		
		int ans = 0;
		int pick = 0;
		for(int i=0;i<M;i++) {
			int pa = findset(edges[i].s);
			int pb = findset(edges[i].e);
			
			if(pa!=pb) {
				union(pa,pb);
				ans += edges[i].w;
				pick++;
			}
			if(pick == N-1)break;
		}
		sb.append(ans);
		System.out.println(sb);
	}
	static void union(int pa, int pb) {
		p[pb] = pa;
		
	}
	static int findset(int s) {
		if(s != p[s]) p[s] = findset(p[s]);
		return p[s];
	}

}
