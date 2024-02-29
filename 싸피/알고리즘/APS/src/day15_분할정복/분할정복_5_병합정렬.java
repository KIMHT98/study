package day15_분할정복;

import java.util.Arrays;

public class 분할정복_5_병합정렬 {
	static int[] arr = {69,10,30,2,16,8,31,22};
	static int[] sortedArr = new int[arr.length];
	public static void main(String[] args) {
		System.out.println("정렬 전 : "+ Arrays.toString(arr));
		
		//값 두개만 인자 넣자
		mergeSort(0, arr.length-1);
		System.out.println("정렬 후 : "+ Arrays.toString(sortedArr));
		
	}
	//left : 구간의 시작 위치 / right : 구간의 끝 위치
	static void mergeSort(int left, int right) {
//		if(left >= right) return; 이렇게 컷 가능
		if(left<right) {
			int mid = (left+right) / 2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid,right);
			
		}
	}
	static void merge(int left, int mid, int right) {
		int l = left;//왼쪽 구간의 시작 포인트
		int r = mid+1;//오른쪽 구간의 시작 포인트
		int idx = left;//정렬된 원소 저장할 위치
		
		//서로 아직 비교할 수 있는 값들이 암아있을 때
		while(l <= mid && r <= right) {
			if(arr[l] <= arr[r]) sortedArr[idx++] = arr[l++];
			else sortedArr[idx++] = arr[r++];
		}
		//왼쪽 구간
		if(l<=mid) {
			for(int i = l; i<=mid;i++) {
				sortedArr[idx++] = arr[i];
			}
		}
		//오른쪽 구간
		else {
			for(int i=r;i<=right;i++) {
				sortedArr[idx++] = arr[i];
			}
		}
//		//마지막 -> 원본에 반영하기
//		for(int i= left;i<=right; i++) {
//			arr[i] = sortedArr[i];
//		}
	}
}
