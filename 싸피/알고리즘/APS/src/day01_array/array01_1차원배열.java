package day01_array;

import java.util.Arrays;

public class array01_1차원배열 {

	public static void main(String[] args) {
		//1. 배열 선언 후 할당
		int[] nums = new int [5];
		//2.배열 선언과 동시에 초기화
		int[] arr = {1,2,3,4,5,};
		System.out.println(Arrays.toString(arr));//1,2,3,4,5
		//3.정방향 순회
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);//1,2,3,4,5
		}
		//4.역방향 순회
		for(int i = arr.length-1;i>=0;i--) {
			System.out.println(arr[i]);//5,4,3,2,1
		}
		//5.특정 인덱스 기분으로 양 옆으로 퍼져나가는 순회
		for(int i = 3;i<arr.length;i++) {
			System.out.println(arr[i]);//4,5
		}
		for(int i=2;i>=0;i--) {
			System.out.println(arr[i]);//3,2,1
		}
	}

}
