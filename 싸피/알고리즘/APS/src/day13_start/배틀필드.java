package day13_start;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 배틀필드 {
	/*
	 * . 평지(전차가 들어갈 수 있다.) * 벽돌로 만들어진 벽 # 강철로 만들어진 벽 - 물(전차는 들어갈 수 없다.) ^ 위쪽을 바라보는
	 * 전차(아래는 평지이다.) v 아래쪽을 바라보는 전차(아래는 평지이다.) < 왼쪽을 바라보는 전차(아래는 평지이다.) > 오른쪽을 바라보는
	 * 전차(아래는 평지이다.)
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Character, int[]> dir = new HashMap<>();
		int[] left = { 0, -1 };
		int[] right = { 0, 1 };
		int[] up = { -1, 0 };
		int[] down = { 1, 0 };
		dir.put('<', left);
		dir.put('>', right);
		dir.put('^', up);
		dir.put('v', down);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			char[][] arr = new char[h][w];
			for (int i = 0; i < h; i++) {
				arr[i] = sc.next().toCharArray();
			}
			int n = sc.nextInt();
			char[] moving = sc.next().toCharArray();
			int currentrow = 0;
			int currentcol = 0;
			int[] currentdir = new int[2];
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (arr[r][c] == '<' || arr[r][c] == '>' || arr[r][c] == '^' || arr[r][c] == 'v') {
						currentrow = r;
						currentcol = c;
						currentdir = dir.get(arr[currentrow][currentcol]);
					}
				}
			}
			for (int i = 0; i < n; i++) {
				switch (moving[i]) {
				case 'U':
					currentdir = up;
					arr[currentrow][currentcol] = '.';
					if (currentrow > 0 && arr[currentrow - 1][currentcol] == '.') {
						currentrow--;
					}
					arr[currentrow][currentcol] = '^';
					break;
				case 'D':
					currentdir = down;
					arr[currentrow][currentcol] = '.';
					if (currentrow < h - 1 && arr[currentrow + 1][currentcol] == '.') {
						currentrow++;
					}
					arr[currentrow][currentcol] = 'v';
					break;
				case 'L':
					currentdir = left;
					arr[currentrow][currentcol] = '.';
					if (currentcol > 0 && arr[currentrow][currentcol - 1] == '.') {
						currentcol--;
					}
					arr[currentrow][currentcol] = '<';
					break;
				case 'R':
					currentdir = right;
					arr[currentrow][currentcol] = '.';
					if (currentcol < w - 1 && arr[currentrow][currentcol + 1] == '.') {
						currentcol++;
					}
					arr[currentrow][currentcol] = '>';
					break;
				case 'S':
					int nr = currentrow + currentdir[0];
					int nc = currentcol + currentdir[1];
					while (nr >= 0 && nr < h && nc >= 0 && nc < w) {
						if (arr[nr][nc] == '*') {
							arr[nr][nc] = '.';
							break;
						} else if (arr[nr][nc] == '#') {
							break;
						}
						nr += currentdir[0];
						nc += currentdir[1];

					}
				}
			}
			System.out.print("#" + t + " ");
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					System.out.print(arr[r][c]);
				}
				System.out.println();
			}
		}
	}

}
