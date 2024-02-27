package day14_subset;

import java.util.Arrays;

public class 부분집합_1_반복문 {

	public static void main(String[] args) {
		String[] 재료 = {"단무지","햄","참치","오이"};
		int n = 4;// 재료는 4개
		int[] sel = new int[n];

		for (int i = 0; i < 2; i++) {
			sel[0] = i;
			for (int j = 0; j < 2; j++) {
				sel[1] = j;
				for (int k = 0; k < 2; k++) {
					sel[2] = k;
					for (int l = 0; l < 2; l++) {
						sel[3] = l;
						System.out.println(Arrays.toString(sel));
						//재료확인을 위한 for문
						for(int m=0;m<n;m++) {
							if (sel[m]==1)
								System.out.print(재료[m]+" ");
						}
						System.out.println();
					
					}
				}
			}

		}

	}
}