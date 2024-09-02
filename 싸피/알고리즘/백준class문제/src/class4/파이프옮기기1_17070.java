package class4;

import java.util.Scanner;

public class 파이프옮기기1_17070 {
	static int N,ans;
	static int[][] board;
	static void dfs(int row, int col, int dir) {
		if(row>=N||col>=N||board[row][col]==1)return;
		if(dir == 2) {
			if(board[row-1][col]==1||board[row][col-1]==1)return;
		}
		if(row==N-1&&col==N-1) {
			ans++;
			return;
		}
		if(dir==0) {
			dfs(row,col+1,0);
			dfs(row+1,col+1,2);
		}else if(dir==1) {
			dfs(row+1,col,1);
			dfs(row+1,col+1,2);
		}else {
			dfs(row,col+1,0);
			dfs(row+1,col,1);
			dfs(row+1,col+1,2);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N][N];
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				board[r][c] = sc.nextInt();
			}
		}
		ans = 0;
		dfs(0,1,0);
		System.out.println(ans);
		
	}

}
