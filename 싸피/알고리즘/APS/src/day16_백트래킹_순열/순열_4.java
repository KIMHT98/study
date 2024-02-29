package day16_백트래킹_순열;

import java.util.Arrays;

public class 순열_4 {
	static int[]nums;//배열
	static int n; //원소 수
	static int r;//뽑을 개수
	static int[] result;//순열 결과 저장
	public static void main(String[] args) {
		nums = new int[] {0,1,2,3,4};
		n = nums.length;
		r = n;
		result = new int[r];
		perm(0,r,0);
	}
	
	//idx : 결과 배열에 저장할 위치
	//visited : 사용한 원소를 기록하기 위한 정수
	public static void perm(int idx,int r,int visited) {
		if(idx==r) {
			//다 뽑은 상태
			System.out.println(Arrays.toString(result));
			return;
		}
		//모든 원소를 돌면서 판단 하자
		for(int i=0;i<n;i++) {
			//해당 인덱스 원소 쓴 경우 pass
			if((visited & (1<<i)) != 0) continue;
			//해당 인덱스 원소 안썼으면
			//결과배열에 넣어줌
			result[idx] = nums[i];
			//재귀
			perm(idx+1,r, visited | (1<<i));//다음자리(결과 배열) 판단
		}
		
	}
	
}
