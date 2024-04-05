package A형대비;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 수영대회결승전 {
	static int N;
	static int[][] sea;
	static boolean[][] visit;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	static class samsung{
		int row, col, sec;

		public samsung(int row, int col, int sec) {
			this.row = row;
			this.col = col;
			this.sec = sec;
		}
	}
	static int bfs(int srow, int scol,int drow, int dcol) {
		Queue<samsung> q = new LinkedList<>();
		visit = new boolean[N][N];
		q.add(new samsung(srow,scol,0));
		visit[srow][scol]=true;
		while(!q.isEmpty()) {
			samsung curr = q.poll();
			if(curr.row==drow&&curr.col==dcol) {
				return curr.sec;
			}
			for(int i=0;i<4;i++) {
				int nr = curr.row+dr[i];
				int nc = curr.col+dc[i];
				if(nr<0||nr>=N||nc<0||nc>=N)continue;
				if(visit[nr][nc])continue;
				if(sea[nr][nc]==1)continue;
				if(sea[nr][nc]==2) {
					if(curr.sec%3==2) {
						q.add(new samsung(nr,nc,curr.sec+1));
						visit[nr][nc] = true;
					}else {
						q.add(new samsung(curr.row,curr.col,curr.sec+1));
					}
				}else {
					q.add(new samsung(nr,nc,curr.sec+1));
					visit[nr][nc] = true;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			sea = new int[N][N];
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					sea[r][c] = sc.nextInt();
				}
			}
			int srow = sc.nextInt();
			int scol = sc.nextInt();
			int drow = sc.nextInt();
			int dcol = sc.nextInt();
			System.out.println("#"+t+" "+bfs(srow,scol,drow,dcol));
		}
	}

}
