package day21_위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 선수과목_14567 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[]arr1 = br.readLine().split(" ");
		int N = Integer.parseInt(arr1[0]);
		int M = Integer.parseInt(arr1[1]);
		int[][] adj = new int[N+1][N+1];
		int[] degree = new int[N+1];
		for(int i=0;i<M;i++) {
			String[] arr2 = br.readLine().split(" ");
			int a = Integer.parseInt(arr2[0]);
			int b = Integer.parseInt(arr2[1]);
			adj[a][b] = 1;
			degree[b]++;
		}
		int[] result = new int[N+1];
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<N+1;i++) {
			if(degree[i]==0) {
				q.add(i);
				result[i]++;
			}
		}
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i=1;i<N+1;i++) {
				if(adj[curr][i]==1) {
					degree[i]--;
					adj[curr][i]=0;
					result[i] = result[curr]+1;
					if(degree[i]==0) {
						q.add(i);
					}
				}
			}
		}
		for(int i=1;i<N+1;i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}

}
