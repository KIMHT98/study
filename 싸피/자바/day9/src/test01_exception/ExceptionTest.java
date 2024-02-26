package test01_exception;

public class ExceptionTest {
	public static void main(String[] args) {
		
		int[] nums = {10};
		//unchecked exception (인덱스 범위 초과)
		//컴파일 시간에 확인X -> 빨간 줄도 없음
		//실행 중 발생
		//예외 처리를 강제하지 않음
		//try ~ catch를 이용하여 처리할 수도 있다.
		System.out.println(nums[1]);
		
		//checked exception (빨간 줄)
		//실행 전에 에러를 말해줘서 실행 불가
		//컴파일 시작네 확인해서 빨간 줄이 생긴 것
		//예외처리를 강제함
		//try ~ catch를 사용(직접 처리)
		//throws 선언하여 예외처리 위임(간접 처리)
//		Thread.sleep(1000);
	}
}
