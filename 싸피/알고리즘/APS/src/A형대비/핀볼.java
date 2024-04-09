package A형대비;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 핀볼 {
	static int N, max;
	static int[][] board;
	static List<Integer>[] hole;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class ball {
		int row, col, point, dir;

		public ball(int row, int col, int point, int dir) {
			this.row = row;
			this.col = col;
			this.point = point;
			this.dir = dir;
		}
	}

	static int changedir1(int i) {
		switch (i) {
		case 0:
			return 2;
		case 1:
			return 3;
		case 2:
			return 1;
		case 3:
			return 0;
		default:
			return -1;
		}
	}

	static int changedir2(int i) {
		switch (i) {
		case 0:
			return 1;
		case 1:
			return 3;
		case 2:
			return 0;
		case 3:
			return 2;
		default:
			return -1;
		}
	}

	static int changedir3(int i) {
		switch (i) {
		case 0:
			return 3;
		case 1:
			return 2;
		case 2:
			return 0;
		case 3:
			return 1;
		default:
			return -1;
		}
	}

	static int changedir4(int i) {
		switch (i) {
		case 0:
			return 2;
		case 1:
			return 0;
		case 2:
			return 3;
		case 3:
			return 1;
		default:
			return -1;
		}
	}

	static int changedir5(int i) {
		switch (i) {
		case 0:
			return 2;
		case 1:
			return 3;
		case 2:
			return 0;
		case 3:
			return 1;
		default:
			return -1;
		}
	}

	static int[] meethole(int num, int row, int col) {
		int[] newposition = new int[2];
		if (row == hole[num - 6].get(0)&&col==hole[num-6].get(1)) {
			newposition[0] = hole[num - 6].get(2);
			newposition[1] = hole[num - 6].get(3);
		}  
		if(row == hole[num - 6].get(2)&&col==hole[num-6].get(3)){
			newposition[0] = hole[num - 6].get(0);
			newposition[1] = hole[num - 6].get(1);
		}
		return newposition;
	}

	static void pinball(int srow, int scol) {
		for (int i = 0; i < 4; i++) {
			ball b = new ball(srow, scol, 0, i);
			int nr = srow;
			int nc = scol;
			while (true) {
				nr += dr[b.dir];
				nc += dc[b.dir];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
					b.dir = changedir5(b.dir);
					b.point++;
//					nr += dr[b.dir];
//					nc += dc[b.dir];
				} else {
//					System.out.println(nr+" "+nc);
					if (board[nr][nc] == -1) {
						max = Math.max(max, b.point);
						break;
					}
					if (board[nr][nc] == 1) {
						b.dir = changedir1(b.dir);
						b.point++;
					} else if (board[nr][nc] == 2) {
						b.dir = changedir2(b.dir);
						b.point++;
					} else if (board[nr][nc] == 3) {
						b.dir = changedir3(b.dir);
						b.point++;
					} else if (board[nr][nc] == 4) {
						b.dir = changedir4(b.dir);
						b.point++;
					} else if (board[nr][nc] == 5) {
						b.dir = changedir5(b.dir);
						b.point++;
					} else if (board[nr][nc] > 5) {
						int[] newposition = meethole(board[nr][nc], nr, nc);
						nr = newposition[0];
						nc = newposition[1];
//						System.out.println(nr+" "+nc);
					}
				}
				b.row = nr;
				b.col = nc;
//				System.out.println(b.row + " " + b.col+" "+b.point);
				if (b.row == srow && b.col == scol) {
					max = Math.max(max, b.point);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			board = new int[N][N];
			hole = new ArrayList[5];
			for (int i = 0; i < 5; i++) {
				hole[i] = new ArrayList<>();
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					board[r][c] = sc.nextInt();
					if (board[r][c] > 5) {
						hole[board[r][c] - 6].add(r);
						hole[board[r][c] - 6].add(c);
					}
				}
			}
//			for(List<Integer> list:hole) {
//				System.out.println(list.toString());
//			}
			max=0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (board[r][c] == 0) {
//						System.out.println(r+" "+c);
						pinball(r, c);
					}
				}
			}
			System.out.println("#" + t + " " + max);

		}
	}

}
/*
 1
5
0 6 7 6 7
5 5 5 5 5
5 5 5 5 5
5 5 5 5 5
5 5 5 5 5
 */
