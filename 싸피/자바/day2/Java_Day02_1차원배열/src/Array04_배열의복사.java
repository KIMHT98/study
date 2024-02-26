import java.util.Arrays;

public class Array04_배열의복사 {

	public static void main(String[] args) {
		int nums[] = {1,2,3,4,5,6};
		
		//1.반복문
		//  - 새로 배열을 만든 다음, 반복문을 돌면서 일일이 옮김
		int[] tmp = new int[nums.length*2];
		for (int i=0; i<nums.length; i++) {
			tmp[i] = nums[i];
			
		}
		System.out.println(Arrays.toString(tmp));
		
		//2.Arrays.copyOf(원본배열, 새로운배열크기);
		int[] tmp2 = Arrays.copyOf(nums, 12);
		System.out.println(Arrays.toString(tmp2));
		
		//3. System.arraycopy(원본배열, 원본배열의시작점, 복사배열, 복사배열의시작점, 복사할크기);
		int[] tmp3 = new int[12];
		System.arraycopy(nums, 0, tmp3, 0, nums.length);
		System.out.println(Arrays.toString(tmp3));
		//Object : 객체의 참조형이 들어간다.
		//모든 배열은 객체로 취금, 참조형
		//int[], boolean[], double[], String[]
		//참조값이 넘어간다.
	}

}
