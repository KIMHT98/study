package day14_subset;

import java.util.Scanner;

public class 햄버거 {
	static int n,l,sumCal, sumScore, max;
	static int[] sel;
	static int[][] cal;
	static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			n = sc.nextInt();
			l = sc.nextInt();
			cal = new int[n][2];
			for(int i=0;i<n;i++) {
				cal[i][0] = sc.nextInt();
				cal[i][1] = sc.nextInt();
			}
			
			max = Integer.MIN_VALUE;
			getScore(0,0,0);
			System.out.println("#"+t+" "+max);
			
		}
	}
	static void getScore(int idx, int currentCalSum, int currentScoreSum) {
		if(idx>=n) {
			if(currentCalSum<=l) {
				max = Math.max(max, currentScoreSum);
			}
			return;
		}
		getScore(idx+1, currentCalSum+cal[idx][1], currentScoreSum+cal[idx][0]);
		getScore(idx+1, currentCalSum, currentScoreSum);
	}

}
