import java.util.Arrays;

public class Array07_빈도수구하기 {

	public static void main(String[] args) {
		int[] nums = {3,7,2,5,6,6,9,2,8,1,1,5,3};
		
		//카운팅 배열의 선언
		//수의 범위:1~9(양의 정수)
		//제일 큰 수: 9
		//제일 큰수 +1로 크기 만든다.
		int[] count = new int[10];
		int[] count2 = new int[10];
		
		//for문 사용
		for(int i=0;i<nums.length;i++) {
			count[nums[i]]++;
		}
		System.out.println(Arrays.toString(count));
		
		//for-each사용
		for(int num:nums) {
			count2[num]++;
		}
		System.out.println(Arrays.toString(count2));

	}

}
