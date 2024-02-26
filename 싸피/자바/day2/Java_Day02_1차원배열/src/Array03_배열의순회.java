import java.util.Arrays;

public class Array03_배열의순회 {

	public static void main(String[] args) {
		int nums[] = {1,2,3,4,5,6};
		//for문 사용
//		for (int i=0; i<nums.length; i++){
//			int x = nums[i];
//			System.out.println(x);
//
//	}	
//		for (int i=0; i<nums.length; i++){
//			nums[i]*=2;
//		}
//		for (int i=0; i<nums.length; i++){
//			int x = nums[i];
//			System.out.println(x);
//		}
		//for-each문 사용(read-only)
		for(int num: nums) {
			System.out.println(num);
			
		}
		
		for(int num: nums) {
			num *= 2;
			
		}
		for(int num: nums) {
			System.out.println(num);
			
		}
//		System.out.println(nums); //참조값(주소값)이 나옴
//		System.out.println(Arrays.toString(nums));//파이썬에서 리스트처럼 나옴
	}
}
