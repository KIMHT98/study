package day03_2tharray;

import java.util.Scanner;

public class array02_2차원배열_연습문제1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//2차원 배열 생성
		int[][]arr =new int[5][5];
		for(int r=0;r<5;r++) {
			for(int c=0;c<5;c++) {
				arr[r][c]=sc.nextInt();
			}
		}
		//델타배열 상 하 좌 우
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		int sum = 0;
		for(int r=0;r<5;r++) {
			for(int c=0;c<5;c++) {
				for(int d=0;d<4;d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					//인접 행과 열이 배열의 크기를 넘어가지 않는 경우
					if(nr>=0&&nr<5&&nc>=0&&nc<5) {
						//해당 요소와 인접 요소의 차이의 절대값을 더해줌
						sum += Math.abs(arr[r][c]-arr[nr][nc]);
					}
				}
			}
		}
		System.out.println(sum);
	}
}
