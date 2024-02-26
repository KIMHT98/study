package day2_array;
import java.util.Scanner;


public class swea2063_중간값찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		selectionSort(arr);
		System.out.println(arr[N/2]);
	}
	public static void selectionSort(int[] arr) {
		for (int i=0;i<arr.length;i++) {
			int minidx = i;
			for(int j = i+1;j<arr.length;j++) {
				if(arr[minidx]>arr[j]) {
					minidx = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minidx];
			arr[minidx] = temp;
		}
	}

}
