package day14_subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 조합_2_재귀_반복 {
	//데이터 배열
	static String[] 재료 = {"상추","패티","치즈","피클"};
	static int n, r;
	static String[] sel;
	public static void main(String[] args) {
		n = 4;//총 재료 개수
		r = 2;//조합할 재료 개수
		sel = new String[r];
		combination(0,0);
	}
	//idx : 현재 내가 판단할 재료의 인덱스
	//sidx : 조합할 재료의 인덱스
	public static void combination(int idx, int sidx) {
		//base case
		if(sidx == r) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		//idx가 경계를 벗어날 걱정 필요x
		
		//recursive case
		for(int i=idx;i<=n-r+sidx;i++) {
			sel[sidx] = 재료[i];//재료 뽑음
			combination(i+1,sidx+1);
		}
		
	}
	
}
