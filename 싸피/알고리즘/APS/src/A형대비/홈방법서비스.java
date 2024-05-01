package A형대비;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 홈방법서비스 {
	//운영 비용 = K * K + (K - 1) * (K - 1)
	//K는 1~2N-1까지
	static int N,M,K, result;
	static int[][] home;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	//탐색
	static int bfs(int r, int c, int k) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][]visit = new boolean[N][N];
		q.add(new int[] {r,c,1});
		visit[r][c]=true;
		int income = 0;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(home[curr[0]][curr[1]]==1) {
				income+=M;
			}
			if(curr[2]==k) continue;
			for(int i=0;i<4;i++) {
				int nr = curr[0]+dr[i];
				int nc = curr[1]+dc[i];
				if(nr<0||nr>=N||nc<0||nc>=N)continue;
				if(visit[nr][nc])continue;
				visit[nr][nc] = true;
				q.add(new int[] {nr,nc,curr[2]+1});
			}
		}
		return income;
	}
	static void search() {
		for(int k=1;k<=(2*N-1);k++) {
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					int income = bfs(r,c,k);
					int profit = income-(k*k+(k-1)*(k-1));
					if(profit>0) {
						result = Math.max(result, income/M);
					
					}
				}
			}
		}
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			home = new int[N][N];
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					home[r][c] = sc.nextInt();
				}
			}
			result = 0;
			search();
			System.out.println("#"+t+" "+result);
		}
	}

}
