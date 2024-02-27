package day14_subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 조합_1_재귀 {
	//데이터 배열
	static String[] 재료 = {"상추","패티","치즈","피클"};
	static int n, r;
	static String[] sel;
	static List<String[]> list = new ArrayList<>();
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
		//idx == n -> 모든 케이스 다 해봤음
		//sidx == r -> 재료 다 뽑았다.(여기서는 2개)
		if(sidx == r) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(idx==n) {
			return;
		}
		
		//recursive case
		//재료 넣었다는 것을 표현해야 함
		sel[sidx] = 재료[idx];
		//해당 idx번째 재료 sidx 위치에 넣은 경우
		combination(idx+1, sidx+1);
		
		//재료 안넣었다는 것은 굳이 안해도 됨
//		sel[sidx] =  null;
		//해당 idx번째 재료 sidx 위치에 안넣은 경우
		combination(idx+1, sidx);
	}
	
}
