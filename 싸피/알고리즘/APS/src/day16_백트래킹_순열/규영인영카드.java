package day16_백트래킹_순열;

import java.util.Arrays;
import java.util.Scanner;

public class 규영인영카드 {
	static int[] myCard, yourCard, visit;

	static void recur(int idx) {
		
	if(idx==9) {
		System.out.println(Arrays.toString(myCard)));
		return;
	}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			myCard = new int[9];
			yourCard = new int[9];
			visit = new int[19];

			for (int i = 0; i < 9; i++) {
				yourCard[i] = sc.nextInt();
				visit[yourCard[i]] = 1;
			}
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (visit[i] == 0) {
					myCard[idx++] = i;
				}
			}
		}
	}

}
