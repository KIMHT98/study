package day02_array;

import java.util.Arrays;

public class array01_search {

	public static void main(String[] args) {
	 int[] arr = {32, 55, 27, 94, 75, 69};
	 selectionSort(arr);
	 System.out.println(Arrays.toString(arr));//[27, 32, 55, 69, 75, 94]
		
	}
	public static void selectionSort(int[] arr) {
		//전체 사이클 반복문
		for(int i=0;i<arr.length;i++) {
			int minIdx = i;
			//한 사이클에 대한 반복문
			//정렬되지 않은 원소들 중 최솟값을 찾아서 교환
			for(int j = i+1;j<arr.length;j++) {
				//minIdx가 가리키는 원소보다 j가 가리키는 원소가 작다면 minIdx 갱신
				if(arr[minIdx]>arr[j]) {
					minIdx = j;
				}
			}
			//minIdx와 기준위치 i교환
			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
		
	}

}