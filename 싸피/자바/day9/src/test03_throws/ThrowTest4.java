package test03_throws;

import java.io.FileNotFoundException;
import java.io.IOException;

class Parent {
	public void method1() throws IOException {

	}

	public void method2() throws ClassNotFoundException {

	}
	
	public void method3() {}
}

public class ThrowTest4 extends Parent{
	@Override
	public void method1() throws FileNotFoundException{
		
	}
	
	@Override
	public void method2() throws Exception{
	//자식은 부모가 던지는 예외보다 조상 예외(더 큰 예외)를 던질 수 없다.	
	}
	
	//하위 클래스의 접근제한자 범위는 상위 클래스보다 크거나 같아야 한다.
	@Override
	void method3() {}
}
