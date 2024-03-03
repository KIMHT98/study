package day16_백트래킹_순열;

import java.util.Arrays;
import java.util.Scanner;

public class 규영이와인영이의카드게임 {
	static int[] ky, iy;
	static Scanner sc = new Scanner(System.in);
	static int kyWin, kyLose;
	static boolean[] visit;

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			ky = new int[9];// 규영이
			iy = new int[9];// 인영이
			visit = new boolean[19];
			kyWin=0; 
			kyLose=0;
			for (int i = 0; i < 9; i++) {
				ky[i] = sc.nextInt();
				visit[ky[i]] = true;
			}
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (!visit[i]) {
					iy[idx++] = i;
				}
			}
			perm(0, 0, 0);

			System.out.println("#" + t + " " + kyWin + " " + kyLose);
		}

	}

	public static void perm(int idx, int kyScore, int iyScore) {
		if (idx == 9) {
			if (kyScore > iyScore)
				kyWin++;
			else if (kyScore < iyScore)
				kyLose++;
			return;
		}
		for (int i = idx; i < 9; i++) {
			int tmp = iy[i];
			iy[i] = iy[idx];
			iy[idx] = tmp;
			int sum = ky[idx] + iy[idx];
			if (ky[idx] > iy[idx]) {
				perm(idx + 1, kyScore + sum, iyScore);
			} else if (ky[idx] < iy[idx]) {
				perm(idx + 1, kyScore, iyScore + sum);
			} else {
				perm(idx + 1, kyScore, iyScore);
			}
			tmp = iy[i];
			iy[i] = iy[idx];
			iy[idx] = tmp;
		}
	}

}
