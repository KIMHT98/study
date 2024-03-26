package day18_그래프탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 점심식사시간 {
	static int N;
	static int[][] room;
	static List<int[]> P,S;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			room = new int[N][N];
			P = new ArrayList<>();
			S = new ArrayList<>();
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					room[r][c] = sc.nextInt();
					if(room[r][c]==1) {
						P.add(new int[] {r,c});
					}else if(room[r][c]>1) {
						S.add(new int[] {r,c});
					}
				}
			}
			
		}
	}

}
