package day20_그래프비용2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 그래프비용_02_프림_우선순위큐 {
	static class Edge implements Comparable<Edge>{
		int A, B,W;

		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.W-o.W;
		}
		
	}
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt();//0부터 시작
		int E = sc.nextInt();
		
		//인접리스트
		List<Edge>[] adj = new ArrayList[V];
		
		//바구니 준비
		for(int i=0;i<V;i++) {
			adj[i] = new ArrayList<>(); 
		}
		
		for(int i=0;i<E;i++) {
			int A = sc.nextInt();//시작정점
			int B = sc.nextInt();//도착정점
			int W = sc.nextInt();//가중치
			
			//무향그래프
			adj[A].add(new Edge(A,B,W));
			adj[B].add(new Edge(B,A,W));
		}
		
		//방문처리를 위한 배열
		boolean[] visited =  new boolean[V];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		visited[0] = true;//0번정점에서 시작
		
		//0번 정점과 인접한 점들 다 넣기
		for(int i=0;i<adj[0].size();i++) {
			pq.add(adj[0].get(i));
		}
		
		int pick = 1;//현재 확보한 정점의 개수;
		int ans = 0;//비용도 0
		
		while(pick !=V) {
			Edge e = pq.poll();
			if(visited[e.B]) continue;//이미 방문한거면 패스
			
			ans+= e.W;//해당 간선의 가중치 더하기
			visited[e.B] = true;
			pick++;
			//반복문을 돌면서 갱신할 수 있는거 전부 갱신
			pq.addAll(adj[e.B]);
		}
		System.out.println(ans);
	
		
	}
	static String input = "7 11\r\n"
			+ "0 1 32\r\n"
			+ "0 2 31\r\n"
			+ "0 5 60\r\n"
			+ "0 6 51\r\n"
			+ "1 2 21\r\n"
			+ "2 4 46\r\n"
			+ "2 6 25\r\n"
			+ "3 4 34\r\n"
			+ "3 5 18\r\n"
			+ "4 5 40\r\n"
			+ "4 6 51";
}
