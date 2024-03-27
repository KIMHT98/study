package day18_그래프탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 점심식사시간 {
	static int N, n, min;
	static List<Integer> D1, D2;
	static int[][] room, S;
	static List<int[]> P;
	static boolean[] sel;

	static void subset(int idx) {
		if (idx >= n) {
			int sum = 0;
			D1 = new ArrayList<>();
			D2 = new ArrayList<>();
			for (int i = 0; i < idx; i++) {
				if (sel[i]) {
					D1.add(Math.abs(S[0][0]-P.get(i)[0])+Math.abs(S[0][1]-P.get(i)[1])+room[S[0][0]][S[0][1]]+1);
				} else {
					D2.add(Math.abs(S[1][0]-P.get(i)[0])+Math.abs(S[1][1]-P.get(i)[1])+room[S[1][0]][S[1][1]]+1);
				}
			}
			Collections.sort(D1);
			Collections.sort(D2);
			for (int i = 3; i < D1.size(); i++) {
				if (D1.get(i) - D1.get(i - 3) > room[S[0][0]][S[0][1]])
					continue;
				D1.set(i, D1.get(i) + room[S[0][0]][S[0][1]]-(D1.get(i) - D1.get(i - 3)) );
			}
			for (int i = 3; i < D2.size(); i++) {
				if (D2.get(i) - D2.get(i - 3) > room[S[1][0]][S[1][1]])
					continue;
				D2.set(i, D2.get(i) + room[S[1][0]][S[1][1]]-D2.get(i) + D2.get(i - 3));
			}
			if(D1.isEmpty()) {
				min = Math.min(min, D2.get(D2.size()-1));
			}else if(D2.isEmpty()) {
				min = Math.min(min, D1.get(D1.size()-1));
			}else {
				min = Math.min(min,Math.max(D2.get(D2.size()-1),D1.get(D1.size()-1)));
			}
			return;
		}
		sel[idx] = false;
		subset(idx + 1);
		sel[idx] = true;
		subset(idx + 1);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			room = new int[N][N];
			P = new ArrayList<>();
			S = new int[2][2]; // S 배열 크기 수정 필요

			int idx = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					room[r][c] = sc.nextInt();
					if (room[r][c] == 1) {
						P.add(new int[] { r, c });
					} else if (room[r][c] > 1) {
						S[idx][0] = r;
						S[idx][1] = c;
						idx++;
					}
				}
			}
			n = P.size();
			min = Integer.MAX_VALUE;
			sel = new boolean[n];
			
			subset(0);
			System.out.println("#"+t+" "+min);

		}
	}

}
