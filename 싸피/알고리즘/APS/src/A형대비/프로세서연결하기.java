package A형대비;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 프로세서연결하기 {
	static int N, result,maxCnt;//cell크기, 결과(전선개수), 연걸된 코어 개수 최대
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };//방향
	static int[][] cell;//cell
	static List<core> cores;//코어들 집합(경계선에 있는 것들 뺴고)

	static class core {
		int row, col;

		public core(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	static void search(int idx, int count, int line) {
		if(idx==cores.size()) {
			if(maxCnt>count)return;//현재 연결된 것들이 최대 개수보다 작으면 패스
			if(maxCnt==count) {//같으면 새로운 전선 개수와 기존 전선 개수중 작은 것
				result = Math.min(result, line);
				return;
			}
			if(maxCnt<count) {//크면 최대개수, 전선 갱신
				maxCnt = count;
				result = line;
				return;
			}
		}
		int r = cores.get(idx).row;
		int c = cores.get(idx).col;
		for(int d=0;d<4;d++) {
			int cnt = 0;//전선개수
			int nr = r;
			int nc = c;
			int startR = r;
			int startC = c;
			while(true) {
				nr += dr[d];
				nc += dc[d];
				if(nr<0||nr>=N||nc<0||nc>=N)break;
				if(cell[nr][nc] != 0) {//연결이 불가능한 경우
					cnt = 0;
					break;
				}
				cnt++;
			}
			for(int i=0;i<cnt;i++) {
				startR += dr[d];
				startC += dc[d];
				cell[startR][startC] = 1;
			}
			if(cnt==0) {//연걸이 안된 경우
				search(idx+1,count,line);
			}else {//연결 시킨 경우
				search(idx+1,count+1,line+cnt);
				startR = r;
				startC = c;
				for(int i=0;i<cnt;i++) {
					startR += dr[d];
					startC += dc[d];
					cell[startR][startC] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			cell = new int[N][N];
			cores = new ArrayList<>();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					cell[r][c] = sc.nextInt();
					if (cell[r][c] == 1) {
						if (r != 0 & r != N - 1 && c != 0 && c != N - 1) {
							cores.add(new core(r, c));
						}
					}
				}
			}
			maxCnt = -1;
			result = 144;
			search(0,0,0);
			System.out.println("#"+t+" "+result);

		}
	}

}
