package day11_Tree2;
import java.util.Arrays;
import java.util.Scanner;

public class 스도쿠검증 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int[][] map = new int[9][9];
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					map[r][c] = sc.nextInt();
				}

			}
			int resultrow = 1;
			int[] arr = new int[9];
			out:for (int r = 0; r < 9; r++) {
				int idx = 0;
				for (int c = 0; c < 9; c++) {
					arr[idx] = map[r][c];
					idx++;
				}
				Arrays.sort(arr);
				for(int i = 0;i<9;i++) {
					if(arr[i] != (i+1)) {
						resultrow = 0;
						break out;
					}
				}

			}
			int resultcol = 1;
			out:for (int c = 0; c < 9; c++) {
				int idx = 0;
				for (int r = 0; r < 9; r++) {
					arr[idx] = map[r][c];
					idx++;
				}
				Arrays.sort(arr);
				for(int i = 0;i<9;i++) {
					if(arr[i] != (i+1)) {
						resultcol = 0;
						break out;
					}
				}

			}
			int resultsmall = 1;
			out:for(int r=0;r<=6;r+=3) {
				int idx = 0;
				for(int c=0;c<=6;c+=3) {
					idx = 0;
					for(int d=0;d<3;d++) {
						arr[idx] =map[r+d][c];
						arr[idx+1] =map[r+d][c+1];
						arr[idx+2] =map[r+d][c+2];
						idx +=3;
					}
					Arrays.sort(arr);
					for(int i = 0;i<9;i++) {
						if(arr[i] != (i+1)) {
							resultsmall = 0;
							break out;
						}
					}
				}
			}
			int sum = resultrow + resultcol + resultsmall;
			if(sum == 3) {
				System.out.println("#"+t+" "+1);
			}else {
				System.out.println("#"+t+" "+0);
			}
		}

	}

}
