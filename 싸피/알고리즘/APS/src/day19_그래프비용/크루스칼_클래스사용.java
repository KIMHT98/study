package day19_그래프비용;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 크루스칼_클래스사용 {
	static class Edge implements Comparable<Edge>
	{
		int start;
		int end;
		int w;

		public Edge(int start, int end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
		
	}
	static int[] p;//대표를 저장할 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt();//정점의 개수(정점의 시작 번호를 알아야 함)
		int E = sc.nextInt();//간선의 개수
		
		//간선의 배열을 이용
		//1. 클래스 정의
		Edge[] edges = new Edge[E];
		for(int i=0;i<E;i++) {
			edges[i] = new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		
		//크루스칼 1단계 : 가중치를 기준으로 오름차순으로 정렬
		Arrays.sort(edges);
		
		//크루스칼 2단계 : V-1개의 간선을 뽑는다.(사이클 발생 안하도록)
		//상호 배타 집합 활용
		p = new int[V];
		//make-set이용(나 자신을 대표로 초기화)
		for(int i=0;i<V;i++) {
			makeset(i);
//			p[i] = i //이렇게 해도 됨
		}
		
		//간선 배열을 순회하는 for문
		//V-1개의 간선을 뽑으려고
		
		int ans = 0;//최소비용의 합
		int pick = 0;//내가 뽑은 간선의 수
		
		for(int i=0;i<E;i++) {
			//i번째 간선을 뽑아 두 정점의 대표를 확인
			int x = edges[i].start;
			int y = edges[i].end;
			
			//x와 y가 대표가 다르다면?
			//합쳐
			if(findset(x) != findset(y)) {
				union(x,y);
				ans += edges[i].w;//현재 간선 선택했으니깐 가중치 추가함
				pick++;
			}
			//어차피 pick == V-1이 된 이후에는 사이클이므로 계산결과는 같음
			//연산 줄이기 위해서 사용
			if(pick == V-1) break;
		}
		System.out.println(ans);
		
		//while문으로 해보기
	}
	static void union(int x, int y) {
		//rank고려x -> 그냥 y집합을 x집합으로 넣음
		p[findset(y)] = findset(x);
		
		//연산량 줄이기 위한 방법
//		p[y] = x;
	}
	static int findset(int x) {
		//정석
//		if(x==p[x])return x;
//		return findset(p[x]);
		
		//path compression사용
		if(x != p[x]) p[x] = findset(p[x]);
		return p[x];
	}
	static void makeset(int x) {
		p[x] = x;//랭크 설정은 패스
		
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
			+ "4 6 51\r\n"
			+ "";

}
