package day20_그래프비용2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 그래프비용_02_다익스트라_반복문 {
	static class Node{
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		
	}
	static final int INF = Integer.MAX_VALUE;
	static int V,E;
	static List<Node>[] adj;//인접리스트
	static int[] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		V = sc.nextInt();
		E = sc.nextInt();
		
		adj = new ArrayList[V];
		//초기화
		for(int i=0;i<V;i++) {
			adj[i] = new ArrayList<>();
		}
		
		dist = new int[V];
		Arrays.fill(dist, INF);
		
		for(int i=0;i<E;i++) {
			//시작정점, 도착정점, 가중치 순으로 입력됨
			adj[sc.nextInt()].add(new Node(sc.nextInt(),sc.nextInt()));
		}
		
		dijkstra(0);
		System.out.println(Arrays.toString(dist));
	}
	static void dijkstra(int start) {
		boolean[] visit = new boolean[V];//방문처리
		
		dist[start] = 0;//시작 노드까지의 거리는 0으로 초기화
		
		//모든 정점을 다 돌 때까지 한다.
		for(int i=0;i<V-1;i++) {
			int min = INF;
			int idx = -1;
			
			for(int j=0;j<V;j++) {
				if(!visit[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}//idx : 방문하지 않았고, 시작정저으로부터 해당 idx 정점까지의 거리가 최소인 인덱스
			
			//시작정점으로부터 갈 수 있는 점들을 다 방문했다.
			if(idx == -1) break;
			
			visit[idx] = true;//선언
			
			for(Node node : adj[idx]) {
				if(!visit[node.v]&&dist[node.v]>dist[idx]+node.w) {
					dist[node.v]= dist[idx]+node.w; 
				}
			}
		}
		
	}
	static String input = "6 11\r\n"
			+ "0 1 4\r\n"
			+ "0 2 2\r\n"
			+ "0 5 25\r\n"
			+ "1 3 8\r\n"
			+ "1 4 7\r\n"
			+ "2 1 1\r\n"
			+ "2 4 4\r\n"
			+ "3 0 3\r\n"
			+ "3 5 6\r\n"
			+ "4 3 5\r\n"
			+ "4 5 12\r\n"
			+ "";
}
