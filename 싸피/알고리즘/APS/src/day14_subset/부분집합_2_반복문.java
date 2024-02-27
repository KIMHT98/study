package day14_subset;

import java.util.Arrays;

public class 부분집합_2_반복문 {

	public static void main(String[] args) {
		String[] 재료 = {"단무지","햄","참치","오이"};
		int n = 4;// 재료는 4개
		int[] sel = new int[n];
		//n개의 재료를 이용하여 만들 수 있는 모든 경우의 수
		for(int i=0;i< (1<<n);i++) {
			//i -> 부분집합의 값인 것은 알았다.
			//i의 재료가 뭔지는 모름
			//for문이 하나 더 필요
			String tmp = "";
			for(int j=0;j<n;j++) {//재료 검사용
				//1이라고 하는 값을 j번 shift하면서 값을 비교
				if((i & (1<<j)) != 0) {
					tmp += 재료[j]+" ";
				}
			}
			System.out.println(tmp);
		}
	}
}