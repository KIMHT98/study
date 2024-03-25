package day08_Queue2;

import java.util.Arrays;

public class 삽입정렬 {

	public static void main(String[] args) {
		int[] data = {69,10,30,2,16,8,31,22};
		int[] sortedArr = insertSort(data);
		System.out.println(Arrays.toString(sortedArr));
		//[2, 8, 10, 16, 22, 30, 31, 69]
	}
	public static int[] insertSort(int[] data) {
		//정렬되지 않은 부분집합 U생성
		for(int i = 1;i<data.length;i++) {
			//비교하면서 순회할 U의 맨 앞 원소
			int key = data[i];
			//정렬된 부분집합 S
			for(int j = i-1;j>=0;j--) {
				if(data[j]>key) {
					//S의 마지막 원소부터 비교 시작
					//key보다 크면 값 교환
					//한 칸 씩 앞으로 가다가 최솟값이면 맨 앞으로도 감
					data[j+1]= data[j];
					data[j] = key;
				}
			}
		}
		return data;
	}

}