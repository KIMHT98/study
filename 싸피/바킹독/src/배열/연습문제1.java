package 배열;

public class 연습문제1 {
	//주어진 길이 N의 int배열 arr에서 합이 100인 서로 다른 위치의 
	//두 원소가 존재하면 1을, 존재하지 않으면 0을 반환하는 
	//함수 func2(int[] arr,int n)을 구하시오.
	public static int func2(int[] arr, int n) {
		int[] occur = new int[101];
		for(int i=0;i<n;i++) {
			if(occur[100-arr[i]]==1)
				return 1;
			occur[arr[i]] = 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,50,80};
		System.out.println(func2(arr,4));

	}

}
