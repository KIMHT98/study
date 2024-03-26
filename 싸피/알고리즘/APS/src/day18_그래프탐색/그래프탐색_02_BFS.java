package day18_그래프탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 그래프탐색_02_BFS {
	static int V; // 정점의 수
	static List<Integer>[] adj; // 인접행렬
	static boolean[] visited; // 방문체크

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		int E = sc.nextInt();

		adj = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			adj[i] = new ArrayList<>();//초기화
		}
		visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adj[A].add(B);
			adj[B].add(A);//무향이니까
		}//간선 정보 입력 완료
		
		for(List list : adj) {
			System.out.println(list);
		}
		BFS(4);
	}

	public static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(v);//시작점 큐에 넣기
		visited[v] = true;//시작접 방문

		//큐가 공백상태가 될 때까지 반복문 수행
		while(!queue.isEmpty()) {
			int curr = queue.poll();//정점 하나 꺼내서
			System.out.println(curr);//경로 찍어보기
			
			//인접리스트
			for(int w:adj[curr]) {
				if(!visited[w]) {
					queue.add(w);
					visited[w] = true;//미리 방문처리를 해서 중복으로 들어가는거 방지
				}
			}
		}
	}
}
