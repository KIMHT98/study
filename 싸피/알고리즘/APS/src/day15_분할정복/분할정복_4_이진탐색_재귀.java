package day15_분할정복;

public class 분할정복_4_이진탐색_재귀 {
	static int[] arr;
	static int key;
	public static void main(String[] args) {
		arr = new int[] { 8, 9, 17, 21, 23, 35, 88, 369 };
		key = 88;
		System.out.println(binarySearch(0, arr.length-1));//true
		System.out.println(binarySearch2(0, arr.length-1));//6

	}
	public static boolean binarySearch(int left, int right) {
		if(left> right) return false; //못찾았다.
		
		int mid = (left+right)/2;//범위 벗어날 수 있긴 함->자료형 맞추기
		
		//같은 경우
		if(arr[mid] == key) return true;//찾았다.
		//큰 경우
		else if(arr[mid]>key) return binarySearch(left, mid-1);
		//작은 경우
		else return binarySearch(mid+1, right);
	}
	public static int binarySearch2(int left, int right) {
		if(left>right) return Integer.MIN_VALUE;
		int mid = (left+right)/2;
		
		if(arr[mid] == key) return mid;
		else if(arr[mid]>key) return binarySearch2(left, mid-1);
		else return binarySearch2(mid+1,right );
	}

}
