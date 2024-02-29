package day16_백트래킹_순열;

import java.util.Arrays;

public class 순열_2 {
	static int[]nums;//배열
	static int n; //원소 수
	static int r; //뽑을 개수
	public static void main(String[] args) {
		nums = new int[] {0,1,2,3,4};
		n = nums.length;
		r = 3;
		perm(0);
	}
	
	//idx : 현재 판단하는 위치
	public static void perm(int idx) {
		//기저조건
		if(idx ==n) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		//재귀조건
		for(int i=idx;i<n;i++) {
			//(i, idx)의 위치를 swap
			swap(i,idx);
			perm(idx+1);
			//(i, idx)의 위치를 swap(원상복구하는 과정)
			swap(i, idx);
		}
	}
	//swap하는 메소드
	public static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	
}
