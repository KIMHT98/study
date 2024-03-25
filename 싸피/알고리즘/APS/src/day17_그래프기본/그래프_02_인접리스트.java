package day17_그래프기본;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_02_인접리스트 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int V = sc.nextInt();//정점의 개수(시작점이 0인지, 1인지를 문제 보고 파악)
		int E = sc.nextInt();//간선의 개수
		
		List<Integer>[] adjList = new ArrayList[V]; //인접리스트 ArrayList의 배열
		
		//adjList의 각 요소는 null이므로 초기화 해줌
		for(int i=0;i<V;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		//간선 입력
		for(int i=0;i<E;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			//가중치를 함께 저장하고 싶으면 사용자장의 클래스 혹은 배열로 넣는다
			adjList[A].add(B);
			adjList[B].add(A);
		}
	}
}
