package day02_array;

import java.util.Arrays;

public class array01_카운팅배열_복수원소 {
//복수 원소 정렬 시에는 첫번째 원소 기준과 두번째 원소 기준 정렬을 둘 다 해줘야 함
	public static void main(String[] args) {
		int[][]arr = {{4,0},{2,1},{4,1},{1,2},{0,3},{3,3},{1,3},{1,4}};
		int[][] result = countingSortSecond(arr);
		int[][] finalArr = countingSortFirst(result);
		System.out.println("두번째 원소 기준 정렬(첫번째는 적용 안됨)");
		for(int r=0;r<arr.length;r++) {
			System.out.print(Arrays.toString(result[r])+" ");
		}
		System.out.println();
		System.out.println("최종(앞, 뒤 원소 다 적용)");

		for(int r=0;r<arr.length;r++) {
			System.out.print(Arrays.toString(finalArr[r])+" ");
		}
	}
	//두번째 원소 기준으로 정렬 -> 첫번째 원소는 적용이 안된 상태
	public static int[][] countingSortSecond(int[][]arr){
		int[] count = new int [100];
		for(int i = 0;i<arr.length;i++) {
			//count배열에 2차원 배열의 두번째 열에 대한 값들로 적용
			count[arr[i][1]] ++;
		}
		//count배열 누적배열로 수정
		for(int i =1;i<count.length;i++) {
			count[i] += count[i-1];
		}
		//정렬된 배열 생성
		int[][] sortedArr = new int[arr.length][];
		//입력 배열의 맨뒤 원소의 두번째 원소값의 count배열에서의 개수 확인
		//count배열의 해당 요소의 값을 하나 빼고 숫자를 가져와서 정렬배열에 넣음
		for(int i= arr.length-1;i>=0;i--) {
			sortedArr[--count[arr[i][1]]] = arr[i];
		}
		return sortedArr;
	}
	//첫번째 원소를 기준으로 정렬 -> 두번째 원소는 적용이 안됨
	public static int[][] countingSortFirst(int[][] arr){
		int[] count = new int [100];
		for(int i = 0;i<arr.length;i++) {
			//count배열에 2차원 배열의 첫번째 열에 대한 값들로 적용
			count[arr[i][0]] ++;
		}
		for(int i =1;i<count.length;i++) {
			count[i] += count[i-1];
		}
		//정렬된 배열 생성
		int[][] sortedArr = new int[arr.length][];
		//입력 배열의 맨뒤 원소의 첫번째 원소값의 count배열에서의 개수 확인
		//count배열의 해당 요소의 값을 하나 빼고 숫자를 가져와서 정렬배열에 넣음
		for(int i= arr.length-1;i>=0;i--) {
			sortedArr[--count[arr[i][0]]] = arr[i];
		}
		return sortedArr;
	
	}


}
