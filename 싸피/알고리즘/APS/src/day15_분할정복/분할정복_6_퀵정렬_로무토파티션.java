package day15_분할정복;

import java.util.Arrays;

public class 분할정복_6_퀵정렬_로무토파티션 {
	static int[] arr = {69,10,10,2,16,8,31,22};

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
	//로무토파티션
	static int partition(int left, int right) {
		int pivot = arr[right];//제일 왼쪽의 값을 피봇으로 설정하겠다
		
		int i = left-1;

		for(int j=left;j<right;j++) {
			if(arr[j] <= pivot) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		//pivot 을 자기 위치로 보내야 된다.
		int tmp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = tmp;
		
		return i+1;//피봇값의 위치
	}

}
