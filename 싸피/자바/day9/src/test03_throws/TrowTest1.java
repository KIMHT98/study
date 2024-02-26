
package test03_throws;

//checked Exception
//-컴파일 시 예외 처리를 강제
//-빨간 줄이 생김
//-throw할 수 있다
//-나를 호출한 곳으로 책임이 넘어간다. -> 어디선가는 처리해야됨
//중간에 직접처리하면 throw안해도 됨 -> 둘 중 하나만 하면됨.
public class TrowTest1 {
	public static void main(String[] args) throws ClassNotFoundException {
		method1();
		//얘까지 throw하면 예외처리하지 않겠다는 뜻
	}
	
	public static void method1() throws ClassNotFoundException {
		//method2를 호출해서 예외를 위임받음
		//처리하거나 위임하거나
		method2();
	}
	
	public static void method2() throws ClassNotFoundException{
		//예외 처리를 위임 -> 이 메서드를 호출한 곳에서 처리
		Class.forName("SSAFY"); //SSAFY라는 이름의 클래스를 로드
		//checked Exception발생
		//직접처리(try ~ catch) or 간접처리
	}
}
