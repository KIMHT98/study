package day17_그래프기본;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_03_간선배열 {
	
	static class Edge{
		int A,B; //시작노드 , 끝 노드

		public Edge(int a, int b) {
			A = a;
			B = b;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + "]";
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();// 정점의 개수(시작점이 0인지, 1인지를 문제 보고 파악)
		int E = sc.nextInt();// 간선의 개수
		
		Edge[] edges = new Edge[E];//객체 배열
		List<Edge> edges2 = new ArrayList<>();//리스트로 만들기
		
		for(int i=0;i<E;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			edges[i] = new Edge(A,B);
		}
		
	}
}
