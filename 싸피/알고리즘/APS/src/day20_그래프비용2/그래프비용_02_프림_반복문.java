package day20_그래프비용2;

import java.util.Arrays;
import java.util.Scanner;

public class 그래프비용_02_프림_반복문 {

	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt();//0부터 시작
		int E = sc.nextInt();
		
		//인접행렬
		int[][] adjArr = new int[V][V];
		
		for(int i=0;i<E;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			//무향그래프
			adjArr[A][B] = adjArr[B][A] = W;
		}
		
		//방문처리를 위한 배열
		boolean[] visited =  new boolean[V];
		int[] p = new int[V];
		int[] dist = new int[V];//key라고 했던 가장 작은 비ㅛㅇ을 저장하기 위한 배열
		
		//dist초기화
		for(int i=0;i<V;i++) {
			dist[i] = INF;
			p[i] = -1;
		}
		//임의의 한 점을 선택해서 돌리기
		dist[0] = 0;//0번부터 하겠다.
		
		int ans = 0;
		//정점의 개수만큼 돌아도 상관X
		//정점 선택하기
		for(int i=0;i<V-1;i++) {
			int min = INF;
			int idx = -1;
			//아직 안뽑힌 정점들 중 가장 작은 값을 뽑겠다.
			for(int j=0;j<V;j++) {
				if(!visited[j]&&dist[j]<min) {
					min = dist[j];
					idx = j;
				}
			}//for문이 끝나면 idx : 가장 작은 값을 가지고 있고 방문하지 않은 정점이 선택됨
			visited[idx] = true;
			
			//선택된 점과 인접한 정점들 중 갱신할 수 있으면 갱신
			for(int j=0;j<V;j++) {
				if(!visited[j] && adjArr[idx][j]!=0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					p[j] = idx;
				}
			}
		}
		
		for(int i=0;i<V;i++) {
			ans += dist[i];
		}
		System.out.println(Arrays.toString(dist));
		System.out.println(Arrays.toString(p));
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
