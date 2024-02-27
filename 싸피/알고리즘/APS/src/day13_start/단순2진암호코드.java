package day13_start;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 단순2진암호코드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> rule = new HashMap<>();
		rule.put("0001101", 0);
		rule.put("0011001", 1);
		rule.put("0010011", 2);
		rule.put("0111101", 3);
		rule.put("0100011", 4);
		rule.put("0110001", 5);
		rule.put("0101111", 6);
		rule.put("0111011", 7);
		rule.put("0110111", 8);
		rule.put("0001011", 9);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[][] board = new char[n][m];
			for (int r = 0; r < n; r++) {
				board[r] = sc.next().toCharArray();
			}

			int startrow = 0;
			int endcol = 0;
			out: for (int r = 0; r <= n; r++) {
				for (int c = m-1; c>=6; c--) {
					if (board[r][c] == '1') {
						startrow = r;
						endcol = c;
						break out;
					}
				}
			}
			int[] list = new int[8];
			char[] arr = board[startrow];
			int idx = 0;
			for(int c=endcol-55;c<=endcol;c+=7) {
				String pattern = "";
				for(int i=0;i<7;i++) {
					pattern += arr[c+i];
				}
				list[idx] = rule.get(pattern);
				idx++;
			}
			int sum = 0;
			int result = 0;
			for(int i=0;i<8;i++) {
				if(i%2==0) {
					sum += (list[i]*3);
				}else {
					sum += list[i];
				}
				result += list[i];
			}
			if(sum%10==0) {
				System.out.println("#"+t+" "+result);
			}else {
				System.out.println("#"+t+" "+0);
			}

		}
	}

}
