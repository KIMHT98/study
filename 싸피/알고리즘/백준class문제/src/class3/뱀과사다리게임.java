package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 뱀과사다리게임 {
	static int n,m;
	static int[][] N,M;
	static int[] map;
	static int[] dr = {1,2,3,4,5,6};
	static int bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start,0});
		boolean[]visit = new boolean[101];
		visit[start] = true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(curr[0] == 100) {
				return curr[1]; 
			}
			for(int i=0;i<6;i++) {
				int nr = curr[0]+dr[i];
				if(nr>100|| visit[nr])continue;
				visit[nr] = true;
				q.add(new int[] {map[nr],curr[1]+1});
			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr1 = br.readLine().split(" ");
		map = new int[101];
		n = Integer.parseInt(arr1[0]);
		m = Integer.parseInt(arr1[1]);
		N = new int[n][2];
		M = new int[m][2];
		for(int i=1;i<=100;i++) {
			map[i] = i;
		}
		for(int i=0;i<n;i++) {
			String[] arr2 = br.readLine().split(" ");
			map[Integer.parseInt(arr2[0])] = Integer.parseInt(arr2[1]);
		}
		for(int i=0;i<m;i++) {
			String[] arr3 = br.readLine().split(" ");
			map[Integer.parseInt(arr3[0])] = Integer.parseInt(arr3[1]);
		}
		System.out.println(bfs(1));
		
	}

}
