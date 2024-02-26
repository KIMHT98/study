package day1_array;

import java.util.Scanner;

public class array01_1차원배열2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트 반복
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[][] arr2 = new int[N][100];
			// 배열 원소 채우기
			int max = Integer.MIN_VALUE;
			int g = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				// 90도 회전한 모습을 2차원 배열로 만들고 박스들을 1로 설정
				for (int j = 0; j < arr[i]; j++) {
					arr2[i][j] = 1;
				}

			}
			for (int i = 0; i < N-1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (arr2[i][arr[i]-1] - arr2[j][arr[i]-1] == 0) {
						g = j - i;
						if (g > max)
							max = g;
						break;
					}
				}
			}
			System.out.printf("#%d %d", t, max);
		}

	}
}
