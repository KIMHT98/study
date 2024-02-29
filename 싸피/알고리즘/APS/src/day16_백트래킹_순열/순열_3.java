package day16_백트래킹_순열;

import java.util.Arrays;

public class 순열_3 {
	static int[]nums;//배열
	static int n; //원소 수
	static int r;//뽑을 개수
	static boolean[] visited; //해당 원소 사용 유무
	static int[] result;//순열 결과 저장
	public static void main(String[] args) {
		nums = new int[] {0,1,2};
		n = nums.length;
		r = 2;
		visited = new boolean[n];
		result = new int[r];
		perm(0, r);
	}
	
	//idx : 결과 배열에 저장할 위치
	public static void perm(int idx,int r) {
		if(idx==r) {
			//다 뽑은 상태
			System.out.println(Arrays.toString(result));
			return;
		}
		//n개의 원소를 순회하면서 썼는지 안썼는지 판단하려고
		for(int i=0;i<n;i++) {
			if(visited[i]) continue;//해당 인덱스 원소 쓴 경우 pass
			//해당 인덱스 원소 안썼으면
			//결과배열에 넣어줌
			result[idx] = nums[i];
			visited[i] = true;//위에서 사용됐으니깐
			perm(idx+1,r);//다음자리(결과 배열) 판단
			visited[i] = false;//다시 원상복구
		}
		
	}
	
}
