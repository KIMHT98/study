package class3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 케빈베이컨의6단계법칙 {
	static int N, M;
	static boolean[] visit;
	static int[][] graph;

//	static void dfs(int root, int num, int prev) {
//		visit[root] = true;
//		if (num == root) {
//			relation[root][num] = 0;
//		} else if (graph[root][num] == 1) {
//			relation[root][num] = 1;
//		} else {
//			if (graph[num][prev] == 1)
//				relation[root][num] += relation[root][prev] + 1;
//			else
//				relation[root][num] += relation[root][prev];
//		}
//		System.out.print("["+num+"]" + "["+prev+"]"+" ");
//		
//		for (int i = 1; i <= N; i++) {
//			if (!visit[i] && graph[num][i] == 1) {
//				dfs(root, i, num);
//			}
//		}
//	}
	static int bfs(int root) {
		int sum = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {root,0});
		visit[root]=true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			sum+=curr[1];
//			System.out.print(curr[1]+" ");
			for(int i=1;i<=N;i++) {
				if(visit[i])continue;
				if(graph[curr[0]][i]==0)continue;
				q.add(new int[] {i,curr[1]+1});
				visit[i] = true;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new int[N + 1][N + 1];
		int[] result = new int[N+1];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = graph[b][a] = 1;
		}
		int minsum = Integer.MAX_VALUE;
		int minidx = N;
		for (int i = 1; i <= N; i++) {
			visit = new boolean[N + 1];
//			dfs(i, i, i);
			result[i]=bfs(i);
			if(result[i]<minsum) {
				minsum = result[i];
				minidx = i;
			}
		}
		System.out.println(minidx);

	}

}
