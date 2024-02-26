package day3_2tharray;

import java.util.Scanner;


public class 달팽이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dr = { 0, 1, 0, -1 };// 우 하 좌 상
		int[] dc = { 1, 0, -1, 0 };// 우 하 좌 상
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			//배열 생성 -> 다 0으로 채우고 시작
			int[][] arr = new int[N][N];
			int nr = 0;
			int nc = 0;
			int num = 0;
			//요소 값이 N^2보다 크거나 같아지면 반복 종료	
			while (num < (N * N)) {//조건문.....
				//방향전환이 총 2N-1번 이루어진다.	
				for (int d = 0; d < 2 * N - 1; d++) {
						//인덱스가 배열 안에 있고 요소 값이 0일때 반복
						while (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 0) {
							arr[nr][nc] = ++num;
							//System.out.println(arr[nr][nc]);
							nr += dr[d % 4];
							nc += dc[d % 4];
							//while조건 벗어나는 경우에 방향 전환해준다.
							if (nr < 0 || nr > N-1 || nc < 0 || nc > N-1 || arr[nr][nc] != 0) {//조건문..
								nr += -dr[d % 4]+ dr[(d+1)%4];
								nc += -dc[d % 4]+ dc[(d+1)%4];
				                break;
						}
					}
				}
				}
				System.out.printf("#%d\n",t);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					System.out.print(arr[r][c] + " ");
				}
				System.out.println();
			}
		}
	}
}
	

