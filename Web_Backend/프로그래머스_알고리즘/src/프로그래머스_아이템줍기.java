import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_아이템줍기 {
	static int minr=101,maxr=0,minc=101,maxc=0;
	static int[][] board;
	static boolean[][] visit = new boolean[50][50];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	static class point {
		int row, col, dist;

		point(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}

	static int bfs(int srow, int scol, int drow, int dcol) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(srow,scol,0));
		visit[srow][scol] = true;
		while(!q.isEmpty()) {
			point curr = q.poll();
			if(curr.row == drow&&curr.col==dcol) {
				return curr.dist;
			}
			for(int i=0;i<4;i++) {
				int nr = curr.row+dr[i];
				int nc = curr.col+dc[i];
				if(nr>=minr&&nr<=maxr&&nc>=minc&&nc<=maxc&&!visit[nr][nc]) {
					visit[nr][nc] = true;
					q.add(new point(nr,nc,curr.dist+1));
				}
				
			}
		}
		return 0;

	}

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int n = rectangle.length;
		for(int i=0;i<n;i++) {
			minr = Math.min(minr,rectangle[i][0]);
			minc = Math.min(minc,rectangle[i][1]);
			maxr = Math.max(maxr,rectangle[i][2]);
			maxc = Math.max(maxc,rectangle[i][3]);
			
		}
		board = new int[maxr+1][maxc+1];
		for(int i= n-1;i>=0;i--) {
			int sx = rectangle[i][0];
			int sy = rectangle[i][1];
			int ex = rectangle[i][2];
			int ey = rectangle[i][3];
			for(int r=sx;r<=ex;r++) {
				for(int c=sy;c<=ey;c++) {
					board[r][c] = 1;
				}
			}
			
		}
		int result = bfs(characterX,characterY,itemX,itemY);
		return result;
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
