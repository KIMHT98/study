package day20_그래프비용2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 최소스패닝트리_크루스칼 {
	static int[] p; //대표를 저장할 배열
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] arr1 = br.readLine().split(" ");
		int V = Integer.parseInt(arr1[0]);
		int E = Integer.parseInt(arr1[1]);
		
		int[][]edges = new int[E][3];
		for(int i=0;i<E;i++) {
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
		
		p = new int[V+1];
		for(int i=1;i<=V;i++) {
			p[i] = i;
		}
		int ans = 0;
		int pick = 0;
		for(int i=0;i<E;i++) {
			int px = findset(edges[i][0]);
			int py = findset(edges[i][1]);
			
			if(px != py) {
				union(px,py);
				ans += edges[i][2];
				pick++;
			}
			if(pick == V-1)break;
		}
		sb.append(ans);
		System.out.println(sb);

	}
	private static void union(int px, int py) {
		p[py] = px;
	}
	private static int findset(int x) {
		if(x != p[x])  p[x] = findset(p[x]);
		return p[x];
	}
	
}
