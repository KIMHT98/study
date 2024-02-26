package test02_try_catch;

public class ExceptionTest1 {
	public static void main(String[] args) {
		//try ~ catch 문을 사용한 예외 처리
		
		int[] nums = {10};
		
		//예외 발생 시 -> 1,4,5 실행
		//예외 처리 못할 시 -> 1만 실행 / 2부터 비정상 종료
		//예외 발생 안했을 때 -> 1, 2, 3, 5실행
		
		try {
			//예외 발생 코드는 try문
			System.out.println("정상 1");//1
			System.out.println(nums[0]);//2
			System.out.println("정상 2");//3
		}catch(ArrayIndexOutOfBoundsException e) {
			//catch() 예외를 파라미터로 넣는다.
			System.out.println("배열의 인덱스를 벗어났음");//4
		}
		System.out.println("종료");//5
	}
}
