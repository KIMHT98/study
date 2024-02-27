package day14_subset;

import java.util.Arrays;
import java.util.Scanner;

public class 요리사 {
	static int n,r;
	static int[][] S;
	static int[] sel;
	static int[] list;
	static int[][] 경우의수;
	static int index = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int t=1;t<=T;t++) {
			n =sc.nextInt();
			S = new int[n][n];
			r=2;
			sel = new int[r];
			경우의수 = new int[n*(n-1) /2][2];
			for(int i=0;i<n;i++) {
				for(int c=0;c<n;c++) {
					S[i][c] = sc.nextInt();
				}
			}
			list = new int[n];
			for(int i=0;i<n;i++) {
				list[i]=i;
			}
			index = 0;
			comb(0,0);
			for(int[] a : 경우의수) {
//				System.out.println(Arrays.toString(a));
			}
			int min = Integer.MAX_VALUE;
			int sum =  0;
			for(int i=0;i<경우의수.length/2;i++) {
				sum+=Math.abs(S[경우의수[i][0]][경우의수[i][1]]+S[경우의수[i][1]][경우의수[i][0]]-S[경우의수[경우의수.length-1-i][0]][경우의수[경우의수.length-1-i][1]]-S[경우의수[경우의수.length-1-i][1]][경우의수[경우의수.length-1-i][0]]);
				min = Math.min(sum, min);
				sum = 0;
			}
			System.out.println("#"+t+" "+min);
			
			
		}
	}
	
	public static void comb(int idx,  int sidx) {
		if(sidx==r) {
			경우의수[index][0] = sel[0];
			경우의수[index][1] = sel[1];
			index++;
			return;
		}if(idx==n) {
			return;
		}
		sel[sidx] = list[idx];
		comb(idx+1,sidx+1);
		
	
		comb(idx+1,sidx);
		}
		
		
	}


