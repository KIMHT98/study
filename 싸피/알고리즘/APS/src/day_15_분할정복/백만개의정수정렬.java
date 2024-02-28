package day_15_분할정복;

import java.util.Scanner;

public class 백만개의정수정렬 {
	static int[] arr = new int[1000000];
	static int[] SortedArr = new int[1000000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<1000000;i++) {
			arr[i] = sc.nextInt();
		}
//		System.out.println(countingSort(arr)[500000]);
//		mergeSort(0,999999);	
		quickSort(0,999999);
		System.out.println(arr[500000]);
		
	}
//	public static int[] countingSort(int[]arr) {
//		int[] count = new int[1000001];
//		for(int i=0;i<1000000;i++) {
//			count[arr[i]]++;
//		}
//		for(int i=1;i<1000001;i++) {
//			count[i]+=count[i-1];
//		}
//		int[] sortedArr = new int[1000000];
//		for(int i=999999;i>=0;i--) {
//			sortedArr[--count[arr[i]]] = arr[i];
//		}
//		return sortedArr;
//	}
//	public static void mergeSort(int left, int right) {
//		if(left<right) {
//			int mid = (left+right)/2;
//			mergeSort(left,mid);
//			mergeSort(mid+1,right);
//			int l = left;
//			int r = mid+1;
//			int idx = left;
//			
//			while(l<=mid && r<=right) {
//				if(arr[l]<=arr[r]) SortedArr[idx++] = arr[l++];
//				else SortedArr[idx++] = arr[r++];
//			}
//			if(l<=mid) {
//				for(int i =l;i<=mid;i++) {
//					SortedArr[idx++] = arr[i];
//				}
//			}else {
//				for(int j=r;j<=right;j++) {
//					SortedArr[idx++] = arr[j];
//				}
//			}
//			for(int i=left;i<=right;i++) {
//				arr[i] = SortedArr[i];
//			}
//		}
//	}
	public static void quickSort(int left, int right) {
		if(left<right) {
//			int pivot = partition_h(left, right);
			int pivot = partition_l(left, right);
			quickSort(left,pivot-1);
			quickSort(pivot+1,right);
		}
	}
//	public static int partition_h(int left, int right) {
//		int pivot = arr[left];
//		int l = left +1;
//		int r = right;
//		while(l<=r) {
//			while(l<=r&&arr[l]<=pivot)l++;
//			while(arr[r]>pivot)r--;
//			if(l<r) {
//				int tmp = arr[l];
//				arr[l] = arr[r];
//				arr[r] = tmp;
//			}
//		}
//		int tmp = arr[left];
//		arr[left] = arr[r];
//		arr[r] = tmp;
//		return r;
//	}
	public static int partition_l(int left, int right) {
		int pivot = arr[right];
		int i = left-1;
		int r = right;
		for(int j=left;j<right;j++) {
			if(arr[j]<=pivot) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		int tmp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = tmp;
		return i+1;
	}
}
