package test05_object_serialization;

import java.io.Serializable;

//Serializable인터페이스를 구현하면 되는데
//부모 구현 -> 자식도 구현되는 것으로 봄
//자식만 구현 -> 부모는 직렬화 불가
//객체를 파일로 저장하기 위해서는 직렬화가 필요 -> Serializable구현
public class Student implements Serializable {
	
	//클래스의 버전을 나타내는 상수값. <= 클래스를 변경했을 때 서로 구분하기 위해 사용
	//역직렬화할 때는 해당 버전으로 만든 파일을 역직렬화할 수 있음
	private static final long serialVersionUID = 1L;
	String name;
	String classNum;

	public Student() {
		super();
	}

	public Student(String name, String classNum) {
		super();
		this.name = name;
		this.classNum = classNum;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", classNum=" + classNum + "]";
	}
}
