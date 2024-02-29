package day16_백트래킹_순열;

import java.util.Arrays;
import java.util.Scanner;

public class 규영이와인영이의카드게임 {
	static int[] g, in;
	static Scanner sc = new Scanner(System.in);
	static int total = 342;
	static int sumg, sumi, wini, wing;
	static int[] result;
	static boolean[] visit;
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			g = new int[9];
			int gidx = 0;
			int iidx = 0;
			in = new int[9];
			result = new int[9];
			visit = new boolean[9];
			int sumg = 0;
			int sumi = 0;
			int wing = 0;
			int wini = 0;
			
			int[] temp = new int[19];
            int idx = 0;
            // 규영이가 받은 9개의 카드
            for (int i=0; i<9; i++) {
                g[i] = sc.nextInt();
                temp[g[i]] = 1;
            }
            
            // 인영이의 카드
            for (int i=1; i<19; i++) {
                if (temp[i] != 1) in[idx++] = i;
            }
			perm(0);
			System.out.println("#"+t+" "+wini+" "+wing);
		}
		
	}
	public static void perm(int idx) {
		if(idx==9) {
			for(int i=0;i<9;i++) {
				if(g[i]>result[i]) sumg+=(g[i]+result[i]);
				else if(g[i]<result[i]) sumi+=(g[i]+result[i]);
			}
			if(sumi>sumg) wini++;
			else if(sumi<sumg) wing++;
			System.out.println(wini+" "+wing);
			return;
		}
		for(int i=0;i<9;i++) {
			if(visit[i]) continue;
			result[idx] = in[i];
			visit[i] = true;
			perm(idx+1);
			visit[i] = false;
		}
	}

}
