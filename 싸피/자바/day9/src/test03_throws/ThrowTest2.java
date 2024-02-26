package test03_throws;

//unchecked Exception발생
//예외 처리 강제하지 않는다.
//throw도 안해도 됨
//하고싶으면 try catch로 해라.
//내부적으로는 예외를 넘기고 있다.
//결국 처리가 되지 않았을 때 비정상적 종료.
public class ThrowTest2 {
	public static void main(String[] args) {
		method1();
	}
	
	public static void method1(){
		try {
		method2();
		} catch(ArithmeticException e) {
			System.out.println("계산 오류");
		}
	}
	public static void method2(){
		int i =1/0;
	}
}
