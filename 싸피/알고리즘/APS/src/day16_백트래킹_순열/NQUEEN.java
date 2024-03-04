package day16_백트래킹_순열;

import java.util.Scanner;

public class NQUEEN {
	static int N, answer;
	static int[] queen;
	
	public static void recur(int r) {
		
		
		column: for(int c=0;c<N;c++) {
			//bc
			if(r==N) {
				answer++;
				return;
			}
			//r,c에 퀸을 놓는다고 가정
			//지금까지 놓인 퀸과 비교
			for(int i=0;i<r;i++) {
				//같은 열에 있거나 대각선 상에 있으면 pass
				if(c==queen[i] || Math.abs(r-i)==Math.abs(c-queen[i])) {
					continue column;
				}
			}
			queen[r] = c;
			recur(r+1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 int T = sc.nextInt();
		 for(int t = 1;t<=T;t++) {
			 N = sc.nextInt();
			 queen = new int[N];
			 answer = 0;
			 recur(0);
			 System.out.println("#"+t+" "+answer);
		 }

	}

}
