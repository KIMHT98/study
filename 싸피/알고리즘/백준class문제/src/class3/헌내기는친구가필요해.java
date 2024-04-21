package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 헌내기는친구가필요해 {
	static int N,M;
	static char[][] campus;
	static boolean[][] visit;
	static int[] dr= {-1,1,0,0}, dc= {0,0,-1,1};
	
	static int bfs(int r, int c) {
		int cnt = 0;
		Queue<int[]> q = new LinkedList<>();
		visit = new boolean[N][M];
		q.add(new int[] {r,c});
		visit[r][c] = true;
		while(!q.isEmpty()) {
			int[] curr =q.poll();
			for(int i=0;i<4;i++) {
				int nr = curr[0]+dr[i];
				int nc = curr[1]+dc[i];
				if(nr<0||nr>=N||nc<0||nc>=M)continue;
				if(visit[nr][nc]||campus[nr][nc]=='X')continue;
				if(campus[nr][nc]=='P')cnt++;
				visit[nr][nc] = true;
				q.add(new int[] {nr,nc});
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] arr = br.readLine().split(" ");
		N = Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);
		campus = new char[N][M];
		for(int i=0;i<N;i++) {
			campus[i] = br.readLine().toCharArray();
		}
		int result = 0;
		out :for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(campus[i][j]=='I') {
					result = bfs(i,j);
					break out;
				}
			}
		}
		if(result == 0) {
			System.out.println("TT");
		}else {
			System.out.println(result);
		}
		
	}

}
