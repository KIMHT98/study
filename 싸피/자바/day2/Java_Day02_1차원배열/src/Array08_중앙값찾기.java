import java.util.Arrays;

public class Array08_중앙값찾기 {
	public static void main(String[] args) {
		// 홀수개인 경우
		int[] nums = { 3, 7, 2, 5, 6, 6, 9, 2, 8, 1, 1, 5, 3 };

		int[] count = new int[10];
		for (int i = 0; i < nums.length; i++) {
			count[nums[i]]++;

		}
		System.out.println(Arrays.toString(count));

		// 카운팅 배열로 중앙값 구하기
		// 앞에서부터 개수를 누적해 나간다.
		// 개수가 중간을 넘어설 때, 그 수가 중앙값.
		int sum = 0;// 개수의 합
		int median = 0;
		for (int i = 1; i <= 9; i++) {
			sum += count[i];
			if (sum >= nums.length / 2 + 1) {
				median = i;
				break;
			}
		}
		System.out.println(median);
	}
}
