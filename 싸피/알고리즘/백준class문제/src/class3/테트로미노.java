package class3;

import java.util.Scanner;

public class 테트로미노 {
	static int N,M,result;
	static boolean[][] visit;
	static int[][] map;
	static int[] dr= {-1,1,0,0}, dc= {0,0,-1,1};
	static void dfs(int r, int c, int cnt, int sum) {
		if(cnt >= 4) {
			result = Math.max(result, sum);
			return;
		}
		for(int i=0;i<4;i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=N||nr<0||nc>=M||nc<0) continue;
			if(visit[nr][nc])continue;
			visit[nr][nc] = true;
			dfs(nr,nc,cnt+1,sum+map[nr][nc]);
			visit[nr][nc] = false;
		}
	}
	static void fucku(int r, int c) {
		if(r<N-2&&c<M-1) {
			result = Math.max(result, map[r][c]+map[r+1][c]+map[r+2][c]+map[r+1][c+1]);
		}
		if(r<N-2&&c>0) {
			result = Math.max(result, map[r][c]+map[r+1][c]+map[r+2][c]+map[r+1][c-1]);
		}
		if(r<N-1&&c<M-2) {
			result = Math.max(result, map[r][c]+map[r][c+1]+map[r][c+2]+map[r+1][c+1]);
		}
		if(r>0&&c<M-2) {
			result = Math.max(result, map[r][c]+map[r][c+1]+map[r][c+2]+map[r-1][c+1]);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		result = 0;
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				map[r][c] = sc.nextInt();
			}
		}
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				visit[r][c]=true;
				dfs(r,c,0,0);
				visit[r][c]= false;
				fucku(r,c);
			}
		}
		System.out.println(result);
	}

}
