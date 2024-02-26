package day12_solve;

import java.util.Scanner;

import javax.lang.model.util.Elements.Origin;

public class 원재의메모리복구 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			char[] originmemory = sc.next().toCharArray();
			int cnt = 0;
			if (originmemory[0] == '0') {
				for (int i = 1; i < originmemory.length; i++) {
					if (originmemory[i] != originmemory[i - 1]) {
						cnt++;
					}
				}
			}else {
				cnt = 1;
				for (int i = 1; i < originmemory.length; i++) {
					if (originmemory[i] != originmemory[i - 1]) {
						cnt++;
					}
				}
			}
			System.out.println("#"+t+" "+cnt);

		}

	}

}
