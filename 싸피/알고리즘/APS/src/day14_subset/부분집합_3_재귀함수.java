package day14_subset;

import java.util.Arrays;

public class 부분집합_3_재귀함수 {
	static String[] 재료 = { "단무지", "햄", "참치", "오이" };
	static int n;// 재료 개수
	// 재귀 함수를 사용하기위해서는 재료를 사용했는지 안했는지 확인을 하기위한 배열이 필요
	static boolean[] sel;

	public static void main(String[] args) {
		n = 4;
		sel = new boolean[n];

		powerset(0);
	}
	//idx : 해당 재료의 인덱스
	public static void powerset(int idx) {
		//base case : 재귀를 빠져나갈 조건
		if(idx>=n) {
			String tmp = "";
			for(int i=0;i<n;i++) {
				if(sel[i])
					tmp+=재료[i]+" ";
			}
			System.out.println(tmp);
			return;
		}
		
		//recursive case : 나 자신을 다시 호출하는 부분
		//이번 재료 안 넣은 경우
		sel[idx] = false;
		powerset(idx+1);//다음 재료 판단
		//이번 재료 넣은 경우
		sel[idx] = true;
		powerset(idx+1);//다음 재료 판단
		
	}

}
