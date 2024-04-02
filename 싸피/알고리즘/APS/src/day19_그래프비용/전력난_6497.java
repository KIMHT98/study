package day19_그래프비용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 전력난_6497 {
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int V = -1;
		int E = -1;
		while (V != 0 || E != 0) {

			String[] arr1 = br.readLine().split(" ");
			V = Integer.parseInt(arr1[0]);
			E = Integer.parseInt(arr1[1]);

			if (V == 0 && E == 0)
				break;

			int[][] edges = new int[E][3];
			int total = 0;
			for (int i = 0; i < E; i++) {
				String[] arr2 = br.readLine().split(" ");
				edges[i][0] = Integer.parseInt(arr2[0]);
				edges[i][1] = Integer.parseInt(arr2[1]);
				edges[i][2] = Integer.parseInt(arr2[2]);
				total += edges[i][2];
			}
			Arrays.sort(edges, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[2] - o2[2];
				}
			});
//			for (int[] a : edges) {
//				System.out.println(Arrays.toString(a));
//			}
			p = new int[V];
			for (int i = 0; i < V; i++) {
				p[i] = i;
			}
			int ans = 0;
			int pick = 0;
			for (int i = 0; i < E; i++) {
				int px = findset(edges[i][0]);
				int py = findset(edges[i][1]);

				if (px != py) {
					union(px, py);
					ans += edges[i][2];
					pick++;
				}
				if (pick == V - 1)
					break;
			}
			sb.append(total - ans).append("\n");
		}
		System.out.println(sb);
	}

	static void union(int px, int py) {
		p[py] = px;
	}

	private static int findset(int i) {
		if (i != p[i])
			p[i] = findset(p[i]);
		return p[i];
	} 

}
