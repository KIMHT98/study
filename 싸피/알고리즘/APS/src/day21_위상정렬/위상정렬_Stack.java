package day21_위상정렬;

import java.util.Scanner;
import java.util.Stack;

public class 위상정렬_Stack {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };
	static String input = "9 9\r\n"
			+ "1 4\r\n"
			+ "1 8\r\n"
			+ "2 3\r\n"
			+ "4 3\r\n"
			+ "8 5\r\n"
			+ "3 5\r\n"
			+ "5 6\r\n"
			+ "9 6\r\n"
			+ "6 7";
	static int V,E;
	static int[][] adj;
	static int[] degree;
	static boolean[] visit;
	static Stack<Integer> stack;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		StringBuilder sb = new StringBuilder();
		
		
		V = sc.nextInt();//정점의 수
		E = sc.nextInt();//간선의 수 -> 방향 있음
		
		adj = new int[V+1][V+1];//정점의 번호가 1부터 시작
		degree = new int[V+1];//진입차수 저장
		visit = new boolean[V+1];
		stack = new Stack<>();
		
		for(int i = 0;i<E;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adj[A][B] = 1;//가중치가 따로 없기 때문에 1로 표기
			//진입 차수 증가
			degree[B]++;
		}
		
		for(int i=1;i<V+1;i++) {
			//진입차수가 0인 정점들을 전부다 DFS탐색 하겠다.
			if(degree[i]==0)
				DFS(i);
		}
		
		//해당 라인 수행되면 위상정렬 끝
		//stack에 다 들어감
		while(!stack.isEmpty()) {
			System.out.println(cook[stack.pop()]);
		}
		
	}
	static void DFS(int v) {
		visit[v] = true;//방문 체크
		for(int i=1;i<V+1;i++) {
			//인접하고, 방문하지 않은 점이 있다면 방문
			if(adj[v][i] == 1 && !visit[i]) {
				DFS(i);
			}
		}
		stack.add(v);
		/*
		 밥하기
		 양념장만들기
		 재료구매
		 채소손질
		 고기손질
		 고기재우기
		 제육볶음만들기
		 식사
		 뒷정리
		*/
	}
	

}
