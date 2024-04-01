package day21_위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ACMCRAFT_1005 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] arr1 = br.readLine().split(" ");
			int V = Integer.parseInt(arr1[0]);
			int E = Integer.parseInt(arr1[1]);
			int[][] adj = new int[V + 1][V + 1];
			int[] result = new int[V+1];
			int[] time = new int[V + 1];
			int[] degree = new int[V + 1];// 진입차수
			String[] arr2 = br.readLine().split(" ");
			for (int i = 1; i < V + 1; i++) {
				time[i] = Integer.parseInt(arr2[i - 1]);
			}
			for (int i = 0; i < E; i++) {
				String[] arr3 = br.readLine().split(" ");
				int a = Integer.parseInt(arr3[0]);
				int b = Integer.parseInt(arr3[1]);
				adj[a][b] = 1;
				degree[b]++;// 진입차수
			}
			int target = Integer.parseInt(br.readLine());
			int ans = 0;
			Queue<Integer> q = new LinkedList<>();
			for(int i=1;i<V+1;i++) {
				if(degree[i]==0) {
					result[i] = time[i];
					q.add(i);
				}
			}
			while(!q.isEmpty()) {
				int curr = q.poll();
				for(int i=1;i<V+1;i++) {
					if(adj[curr][i]==1) {
						degree[i]--;
						adj[curr][i] = 0;
						result[i] = Math.max(time[i]+result[curr], result[i]);
						if(degree[i]==0) {
							q.add(i);
						}
					}
				}
			}
			System.out.println(result[target]);
		}
	}

}
