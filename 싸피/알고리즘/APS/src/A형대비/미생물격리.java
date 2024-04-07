package A형대비;

import java.util.Scanner;

public class 미생물격리 {
	static int N, M, K;
	static microbe[][] cell;
	static microbe[] cluster;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	static class microbe {
		int num, row, col,sum, cnt, dir, time;

		public microbe(int num, int row, int col,int sum, int cnt, int dir, int time) {
			this.num = num;
			this.row = row;
			this.col = col;
			this.sum = sum;
			this.cnt = cnt;
			this.dir = dir;
			this.time = time;
		}

		@Override
		public String toString() {
			return "microbe [num=" + num + ", row=" + row + ", col=" + col + ", sum=" + sum + ", cnt=" + cnt + ", dir="
					+ dir + ", time=" + time + "]";
		}

		

	}
    static int oppositeDir(int dir) {
        switch (dir) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 4;
            case 4:
                return 3;
            default:
                return -1;
        }
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			cell = new microbe[N][N];
			cluster = new microbe[K];
			int idx = 0;
			for (int i = 0; i < K; i++) {
				int num = idx++;
				int row = sc.nextInt();// 행
				int col = sc.nextInt();// 열
				int cnt = sc.nextInt();// 미생물 수
				int sum = cnt;
				int dir = sc.nextInt();// 방향
				int time = 0;
				cluster[i] = new microbe(num, row, col,sum, cnt, dir, time);
				cell[row][col] = cluster[i];
			}
			for (int m = 0; m < M; m++) {
				for (int i = 0; i < K; i++) {
					microbe now = cluster[i];
					if (now == null)
						continue;
					now.time++;
					cell[now.row][now.col] = null;
					now.row += dr[now.dir - 1];
					now.col += dc[now.dir - 1];
					if(now.row==0||now.row==N-1||now.col==0||now.col==N-1) {
						now.sum/=2;
						now.cnt/=2;
						if(now.cnt==0) {
							cluster[i] = null;
							continue;
						}
						now.dir = oppositeDir(now.dir);
					}
					if (cell[now.row][now.col] == null) {
						cell[now.row][now.col] = now;
					} else {
						if (cell[now.row][now.col].time != now.time) {
							cell[now.row][now.col] = now;
						} else {
							if (cell[now.row][now.col].cnt > now.cnt) {
								cell[now.row][now.col].sum += now.cnt;
								cluster[cell[now.row][now.col].num] = cell[now.row][now.col];
								cluster[i] = null;
							} else {
//								System.out.println(cell[now.row][now.col].num);
								now.sum += cell[now.row][now.col].sum;
								cluster[cell[now.row][now.col].num] = null;
								cell[now.row][now.col]=now;
								cluster[i] = now;
							}
						}
					}
//					
				}
				for(int i=0;i<K;i++) {
					if(cluster[i]!=null) {
						cluster[i].cnt = cluster[i].sum;
						cell[cluster[i].row][cluster[i].col] = cluster[i];
					}
				}
			}
			int sum = 0;
			for (int i = 0; i < K; i++) {
				if (cluster[i] != null) {
					sum += cluster[i].sum;
//					System.out.println(cluster[i]);
				}
			}
			System.out.println("#" + t + " " + sum);

		}
	}

}
