package 배열;

import java.util.Scanner;

public class boj13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] countb = new int[7];
		int[] countg = new int[7];
		for (int i = 0; i < n; i++) {
			int s = sc.nextInt();
			int semester = sc.nextInt();
			if (s == 1)
				countb[semester] ++;
			else
				countg[semester] ++;
		}
		int roomcnt = 0;
		for (int i = 1; i < 7; i++) {
			if (countb[i] % k == 0)
				roomcnt += (countb[i] / k);
			else
				roomcnt += ((countb[i] / k) + 1);
			if (countg[i] % k == 0)
				roomcnt += (countg[i] / k);
			else
				roomcnt += ((countg[i] / k) + 1);

		}
		System.out.println(roomcnt);

	}
}
