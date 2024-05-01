package A형대비;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽돌깨기 {
	static int N, W, H, min;
	static int[][] board, copy;
	static int[] selected, dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	// 부실곳 선택(중복순열)
	static void perm(int idx) {
		if (idx == N) {
			breakBrick(selected);
			min = Math.min(min, countBrick());
//			if (countBrick() == 5) {
//				System.out.println(Arrays.toString(selected));
//				for (int[] b : board) {
//					System.out.println(Arrays.toString(b));
//				}
//			}
			copyBoard();
			return;
		}
		for (int i = 0; i < W; i++) {
			selected[idx] = i;
			perm(idx + 1);
		}
	}

	// 벽돌깨버리기
	static void breakBrick(int[] arr) {
		int r = 0;
		int c = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < H; j++) {
				if (board[j][arr[i]] != 0) {
					r = j;
					c = arr[i];
					break;
				}
			}
			bfs(r, c);
			settingBoard();
		}
	}

	// 벽돌들 다시 세팅
	static void settingBoard() {
		for (int c = 0; c < W; c++) {
			for (int r = 0; r < H - 1; r++) {
				if (board[r][c] != 0 && board[r + 1][c] == 0) {
					for (int i = r + 1; i > 0; i--) {
						board[i][c] = board[i - 1][c];
					}
					board[0][c] = 0;
				}
			}
			
		}
	}

	// 탐색하면서 깨기
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c, board[r][c] });
		board[r][c] = 0;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int num = curr[2];
			for (int i = 1; i < num; i++) {
				for (int d = 0; d < 4; d++) {
					int nr = curr[0] + dr[d] * i;
					int nc = curr[1] + dc[d] * i;
					if (nr < 0 || nr >= H || nc < 0 || nc >= W || board[nr][nc] == 0)
						continue;
					if (board[nr][nc] != 0) {
						q.add(new int[] { nr, nc, board[nr][nc] });
						board[nr][nc] = 0;
					}
				}
			}
		}
	}

	// board복사
	static void copyBoard() {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				board[r][c] = copy[r][c];
			}
		}
	}

	// 남은 벽돌 세기
	static int countBrick() {
		int cnt = 0;
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if (board[r][c] != 0) {
					cnt++;
				}
			}
		}
//		System.out.println(cnt);
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			board = new int[H][W];
			copy = new int[H][W];
			min = 180;
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					board[r][c] = sc.nextInt();
					copy[r][c] = board[r][c];
				}
			}
			selected = new int[N];
			perm(0);
			System.out.println("#" + t + " " + min);

		}
	}

}
