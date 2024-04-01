package day19_그래프비용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 도시분할계획_1647 {
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr1 = br.readLine().split(" ");
		int N = Integer.parseInt(arr1[0]);
		int M = Integer.parseInt(arr1[1]);
		p = new int[N+1];
		int[][] edges = new int[M][3];
		for(int i=0;i<M;i++) {
			String[] arr2 = br.readLine().split(" ");
			edges[i][0] = Integer.parseInt(arr2[0]);
			edges[i][1] = Integer.parseInt(arr2[1]);
			edges[i][2] = Integer.parseInt(arr2[2]);
		}
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2]-o2[2];
			}
		});
		for(int i=1;i<=N;i++) {
			p[i] = i;
		}
		int ans = 0;
		int pick = 0;
		for(int i=0;i<M;i++) {
			int px = findset(edges[i][0]);
			int py = findset(edges[i][1]);
			
			if(px!=py) {
				p[py] = px;
				ans+=edges[i][2];
				pick++;
			}
			if(pick == N-1)break;
			
		}
		
	}
	static int findset(int x) {
		if(x != p[x]) p[x] = findset(p[x]);
		return p[x];
	}

}
