package day20_그래프비용2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 복제로봇_1944 {
	static int N, M,ans;
	static char[][] arr;
	static boolean[][] visit;
	static int[][] keys;
	static int[] results;
	static int[] dr= {-1,1,0,0}, dc= {0,0,-1,1};
	static void search(int r, int c) {
		for(int i=0;i<M;i++) {
			bfs(i,i,r,c,keys[i][0],keys[i][1]);
			if(ans==-1)return;
		}
		}
	static void bfs(int i,int keynum,int r, int c, int drow, int dcol) {
		if(i==M)return;
		Queue<int[]> q= new LinkedList<>();
		q.add(new int[] {r,c,0});
		visit[r][c]=true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(curr[0]==drow&&curr[1]==dcol) {
				results[i] = Math.min(results[i], curr[2]);
				for(int row =0;row<N;row++) {
					for(int col=0;col<N;col++) {
						if(visit[row][col]) visit[row][col]=false;
					}
				}
				bfs(i+1,keynum,keys[keynum][0],keys[keynum][1],keys[i+1][0],keys[i+1][1]);
				return;
			}
			for(int d=0;d<4;d++) {
				int nr = curr[0]+dr[d];
				int nc = curr[1]+dc[d];
				if(nr<0||nr>=N||nc<0||nc>=N)continue;
				if(visit[nr][nc])continue;
				if(arr[nr][nc]=='1')continue;
				visit[nr][nc] = true;
				q.add(new int[] {nr,nc,curr[2]+1});
			}
		}
		ans = -1;
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr1 = br.readLine().split(" ");
		N = Integer.parseInt(arr1[0]);
		M = Integer.parseInt(arr1[1]);
		arr = new char[N][N];
		visit = new boolean[N][N];
		keys = new int[M+1][2];
		results = new int[M];
		Arrays.fill(results, 251);
		int srow=0, scol=0,idx=0;
		for(int r=0;r<N;r++) {
			arr[r] = br.readLine().toCharArray();
			for(int c=0;c<N;c++) {
				if(arr[r][c]=='S') {
					srow = r;
					scol = c;
				}
				if(arr[r][c]=='K') {
					keys[idx] = new int[]{r,c};
					idx++;
				}
			}
		}
		ans=0;
		keys[M] = new int[] {-1,-1};
		search(srow,scol);
		if(ans == -1) {
			System.out.println(ans);
		}else {
			for(int i=0;i<M;i++) {
				ans+=results[i];
			}
			System.out.println(ans);
		}
		
	}

}
