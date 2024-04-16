package class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 쉬운최단거리 {
	static int n,m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr= {-1,1,0,0}, dc= {0,0,-1,1};
	static void bfs(int r, int c) {
		Queue<int[]> q= new LinkedList<>();
		q.add(new int[] {r,c,0});
		visit[r][c] = true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			map[curr[0]][curr[1]] = curr[2];
			for(int i=0;i<4;i++) {
				int nr = curr[0]+dr[i];
				int nc = curr[1]+dc[i];
				if(nr<0||nr>=n||nc<0||nc>=m)continue;
				if(visit[nr][nc])continue;
				if(map[nr][nc]==0)continue;
				q.add(new int[] {nr,nc,curr[2]+1});
				visit[nr][nc] = true;
				}
			}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!visit[i][j]&&map[i][j]!=0)map[i][j] = -1;
			}
		}
		}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m];
		int srow = 0;
		int scol = 0;
		for(int r=0;r<n;r++) {
			for(int c=0;c<m;c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c]==2) {
					srow = r;
					scol = c;
				}
			}
		}
		bfs(srow,scol);
		for(int r=0;r<n;r++) {
			for(int c=0;c<m;c++) {
				sb.append(map[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
