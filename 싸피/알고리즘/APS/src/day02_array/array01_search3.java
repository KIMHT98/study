package day02_array;

import java.util.Arrays;

public class array01_search3 {

	public static void main(String[] args) {
	 int[] arr = {32, 55, 27, 94, 75, 69};
	 int[] sortedArr = countingSort(arr);
	 System.out.println(Arrays.toString(sortedArr));//[27, 32, 55, 69, 75, 94]
		
	}
	public static int[] countingSort(int[] arr) {
		//count배열의 길이 = arr의 최댓값
		int[] count = new int[100];
		//원소들의 개수를 세어서 count배열에 저장
		for(int i=0; i<arr.length;i++) {
			count[arr[i]]++;
		}
		//count배열을 누적합 배열로 만든다.
		for(int i =1;i<count.length;i++) {
			count[i] += count[i-1];
		}
		int[] sortedArr = new int[arr.length];
		
		//역방향 순회를 하면서 누적합 배열을 보고 위치를 찾아준다.
		for(int i = arr.length-1; i>=0;i--) {
			sortedArr[--count[arr[i]]] = arr[i];
		}
		return sortedArr;
	}

}