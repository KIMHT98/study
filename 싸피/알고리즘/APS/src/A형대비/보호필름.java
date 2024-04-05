package A형대비;

import java.util.Scanner;

public class 보호필름 {
	static int D, W, K, ans;
	static int[][] arr;
	static int[] A, B;

	static void makefilm(int row, int cnt) {
		if (ans <= cnt)
			return;
		if (search(arr)) {
			ans = Math.min(ans, cnt);
			return;
		}
		if (row >= D)
			return;
		// 안넣는 경우
		makefilm(row + 1, cnt);
		int[] tmp = arr[row];
		// A넣는 경우
		arr[row] = A;
		makefilm(row + 1, cnt + 1);

		// B넣는 경우
		arr[row] = B;
		makefilm(row + 1, cnt + 1);

		// 원상복구
		arr[row] = tmp;
	}

	static boolean search(int[][] a) {
		for (int c = 0; c < W; c++) {
			int cnt = 1;
			boolean isok = false;
			for (int r = 1; r < D; r++) {
				if(arr[r][c]==arr[r-1][c])
					cnt++;
				else
					cnt=1;
				if(cnt >=K) {
					isok = true;
					break;
			}
				if (isok) {
					cnt++;
					break;
				}
			}
			if(!isok)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			arr = new int[D][W];
			for (int r = 0; r < D; r++) {
				for (int c = 0; c < W; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			A = new int[W];
			B = new int[W];
			for (int i = 0; i < W; i++) {
				A[i] = 0;
				B[i] = 1;
			}
			ans = Integer.MAX_VALUE;
			makefilm(0, 0);
//			for (int[] a : arr) {
//				System.out.println(Arrays.toString(a));
//			}
			System.out.println("#" + t + " " + ans);

		}
	}

}
