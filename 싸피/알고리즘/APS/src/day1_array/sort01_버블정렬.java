package day1_array;

import java.util.Arrays;

public class sort01_버블정렬 {

	public static void main(String[] args) {
		int[] arr = {12,46,32,47,48,30,11};
		//최대 총 n-1번의 싸이클이 필요(마지막은 굳이 안해도됨)
		for(int j=0;j<arr.length-1;j++) {
		//한 싸이클
		//j가 하나씩 커질 수록 배열의 마지막 칸이 각 싸이클에서의 
		//최댓값으로 정해지니깐 순회를 하나씩 줄여도됨 -> j를 빼주는 것으로 표현 가능
		for(int i = 0 ; i < arr.length-1-j; i++) {
			if(arr[i]>arr[i+1]) {
				//자리 바꾸기
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		}
		System.out.println(Arrays.toString(arr));//[11, 12, 30, 32, 46, 47, 48]
	}

}
