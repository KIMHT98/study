package day18_그래프탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 치즈도둑 {
	static int N,cnt,day;
	static boolean[][] visit;
	static int[][] arr;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		visit[r][c] = true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int i=0;i<4;i++) {
				int nr = curr[0]+dr[i];
				int nc = curr[1]+dc[i];
				if(nr<0||nr>=N||nc<0|nc>=N) continue;
				if(visit[nr][nc]) continue;
				if(arr[nr][nc]<=day)continue;
				q.add(new int[] {nr,nc});
				visit[nr][nc] = true;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			arr =  new int[N][N];
			int maxday = 0;
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					arr[r][c] = sc.nextInt();
					maxday = Math.max(maxday, arr[r][c]);
				}
			}
			int max = 0;
			for(int k=0;k<=maxday;k++) {
				day = k;
				cnt = 0;
				visit = new boolean[N][N];
				for(int r=0;r<N;r++) {
					for(int c=0;c<N;c++) {
						if(!visit[r][c]&&arr[r][c]>k) {
							bfs(r,c);
							cnt++;
						} 
					}
				}
				max = Math.max(max, cnt);
			}
			System.out.println("#"+t+" "+max);
		}
	}

}
