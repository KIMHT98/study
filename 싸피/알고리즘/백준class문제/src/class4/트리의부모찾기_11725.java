package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 트리의부모찾기_11725 {
	static int N;
	static List<Integer>[] adj;
	static boolean[] visit;
	static int[] parent;
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visit[1] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int n:adj[curr]) {
				if(visit[n])continue;
				visit[n] = true;
				q.add(n);
				parent[n] = curr;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i=1;i<N;i++) {
			String[] arr = br.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			adj[a].add(b);
			adj[b].add(a);
		}
		visit = new boolean[N+1];
		parent = new int[N+1];
		bfs();
		for(int i=2;i<=N;i++) {
			System.out.println(parent[i]);
		}
		

	}

}
