package day15_분할정복;

public class 분할정복_3_이진탐색_반복 {
	static int[] arr;
	static int key;

	public static void main(String[] args) {
		arr = new int[] { 8, 9, 17, 21, 23, 35, 88, 369 };
		key = 88;
		System.out.println(binarySearch(0, arr.length - 1));// 6

	}
	public static int binarySearch(int left, int right) {
		while(left<=right) {
			int mid = (left+right)/2;
			if(arr[mid] == key) return mid;
			else if(arr[mid]>key) return binarySearch(left, mid-1);
			else return binarySearch(mid+1, right);
		}
		return Integer.MIN_VALUE;
	}
}
