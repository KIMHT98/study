package test05_interface;

public class Test {

	public static void main(String[] args) {
		//인터페이스의 모든 멤버변수는 static final -> 인터페이스로 접근
		System.out.println(MyInterface.MEMBER1);
		System.out.println(MyInterface.MEMBER2);
		
		//객체 생성
		MyClass mc = new MyClass();
		mc.method1();
		mc.method2();
		
		//해당 객체가 인터페이스를 구현한 경우 인터페이스를 참조한 타입으로 활용 가능
		 MyInterface m1 = mc;
		 MyInterface mi2 = new MyClass();
		

	}

}
