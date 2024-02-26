
public class Array05_최대최소값 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {112,25,139,245,5,116};
		
		//최대 최소값 찾는 법
		//1. 최대값을 담을 변수는 max, 최소값을 담을 변수는 min으로 선어
		
		//max는 주어진 수의 범위보다 작은 수로 초기화
		//min은 주어진 수의 범위보다 큰 수로 초기화
		int max = 0;
		int min = 500;
		
//		//메소드 사용
//		int max = Integer.MIN_VALUE;//int형에서 가장 작은 값(-21억쯤)
//		int min = Integer.MAX_VALUE;//int형에서 가장 큰 값(21억쯤)
//		
//		//배열의 가장 첫 원소로 초기화;
//		int max = nums[0];
//		int min = nums[0];
	
		//2.반복문을 활용하여 주어진 배열의 수를 순회
		for(int i=0; i<nums.length; i++) {
			//max보다 큰 수를 만나면 => max를 그 수로 업데이트
			//min보다 작은 수를 만나면 => min을 그 수로 업데이트
			if(nums[i]>max) {
				max = nums[i];
			}
			if(nums[i] < min) {
				min = nums[i];
			}
		}
		System.out.println("max : "+max);
		System.out.println("min : "+min);
	}

}
