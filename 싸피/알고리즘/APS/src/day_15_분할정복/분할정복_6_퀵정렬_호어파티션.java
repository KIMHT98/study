package day_15_분할정복;

import java.util.Arrays;

public class 분할정복_6_퀵정렬_호어파티션 {
	static int[] arr = {69,10,30,2,16,8,31,22};

	public static void main(String[] args) {
		
		quickSort(0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	static void quickSort(int left, int right) {
		if(left<right) {
			int pivot = partition(left, right);
			quickSort(left, pivot -1);
			quickSort(pivot+1, right);
		}
	}
	//호어파티션
	static int partition(int left, int right) {
		int pivot = arr[left];//제일 왼쪽의 값을 피봇으로 설정하겠다
		
		int l = left+1, r = right;//시작은 피봇 한칸 옆부터
		
		while(l<=r) {
			//l : pivot보다 큰 값을 찾을 때까지 이동하겠다.
			while(l<=r && arr[l] <= pivot) l++;
			//r : pivot보다 작거나 같은 값을 만날때까지 이동하겠다.
			while(arr[r]>pivot)r--;
			
			if(l<r) {
				int tmp = arr[l];
				arr[l] = arr[r];
				arr[r] = tmp;
			}
		}
		//r이 pivot이 위치해야할 곳까지 이동을 마친 상태
		int tmp = arr[left];//pivot
		arr[left] = arr[r];
		arr[r] = tmp;
		
		return r;//피봇값의 위치
	}

}
