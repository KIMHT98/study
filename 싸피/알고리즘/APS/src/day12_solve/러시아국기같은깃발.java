package day12_solve;

import java.util.Arrays;
import java.util.Scanner;

public class 러시아국기같은깃발 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[][] flag = new char[n][m];
			for(int r=0;r<n;r++) {
				flag[r] = sc.next().toCharArray();
			}
			int min = Integer.MAX_VALUE;
			for(int w = 1;w<=n-2;w++) {
				for(int b = w+1; b<=n-1;b++) {
					int cnt = 0;
					for(int r = 0;r<w;r++) {
						for(int c = 0; c<m;c++) {
							if(flag[r][c]!='W')cnt++;
						}
					}
					for(int r = w;r<b;r++) {
						for(int c = 0;c<m;c++) {
							if(flag[r][c]!='B')cnt++;
						}
					}
					for(int r = b;r<n;r++) {
						for(int c= 0; c<m; c++) {
							if(flag[r][c]!='R')cnt++;
						}
					}
					min = Math.min(cnt, min);
				}
			}
			System.out.println("#"+t+" "+min);
		}
	}

}
