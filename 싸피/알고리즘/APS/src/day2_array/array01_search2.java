package day2_array;

public class array01_search2 {

	public static void main(String[] args) {
	 int[] arr = {23,44,55,66,77,88,99};
	 int result = binarySearch(arr,55);
	 System.out.println(result);//2
		
	}
	public static int binarySearch(int[] arr, int key) {
		//열린 구간으로 할지 닫힌 구간으로 할지 선택 가능
		//닫힌 구간으로 수행 예시
		int left = 0;
		int right = arr.length-1;
		
		//반씩 탐색하면서 과정을 반복
		//과정이 반복되면서 left,right가 옮겨지니깐 언젠가는 둘이 같아지거나 위치가 반대로됨.
		while(left<=right) {
			int mid = (left+right)/2;
			if(key==arr[mid]) {
				return mid;
			}
			//우측을 중간 값보다 작은 쪽으로 옮김
			else if(key<arr[mid]) {
				right = mid - 1;
			}
			//좌측을 중간 값보다 큰 쪽으로 옮김
			else {
				left = mid +1;
			}
		}
		return -1;
	}

}
