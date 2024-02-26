package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 마인크래프트_18111 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int b = sc.nextInt();
		int[][] ground = new int[n][m];
		int min = 256;
		int max = 0;
		for(int r=0;r<n;r++) {
			for(int c=0;c<m;c++) {
				ground[r][c] = sc.nextInt();
				min = Math.min(min, ground[r][c]);
				max = Math.max(max, ground[r][c]);
			}
		}
		int sec = 0;
		for(int r=0;r<n;r++) {
			for(int c=0;c<m;c++) {
				for(int s = min;s<=max;s++) {
					int now = ground[r][c];
					if(now > s) {
						sec = sec + (now-s)*2;
					}else if(now<s) {
						if(b>=(s-now)) {
							sec = sec+(s-now);
							b-=(s-now);
						}
						
					}
				}
			}
		}
		
	}

}
