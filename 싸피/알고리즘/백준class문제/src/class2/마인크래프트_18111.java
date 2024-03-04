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
		int sec =0;
		int finalsec = Integer.MAX_VALUE;
		int maxH = Integer.MIN_VALUE;
		 for(int h = min;h<=max;h++) {
			sec =0;
			boolean isflat = true;
			int inventory = b;
			out: for(int r=0;r<n;r++) {
				for(int c=0;c<m;c++) {
					if(ground[r][c]==h)continue;
					else if(ground[r][c]>h) {
						sec+= 2*(ground[r][c]-h);
						inventory+=(ground[r][c]-h);
					}else {
						inventory-=(h-ground[r][c]);
						if(inventory<0) {
							isflat = false;
							break out;
						}
						sec+=(h-ground[r][c]);
					}
				}
			}
			if(isflat) {
				if(sec<=finalsec) {
					finalsec = sec;
					maxH = h;
				}
			}
		}
		System.out.println(finalsec+" "+maxH);
		
	}

}
