package test02_class_reflection;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		//Class<T> : 클래스 자체에 대한 정보를 담고 있는 클래스
		//Person => 객체의 타입을 지정할 때, 객체를 생성할 때. 사용
		//Class<Person> : Person이란 클래스 자체에 대한 정보구나...(뭔소리?)
		//	- 이 클래스의 이름이 뭔지. 생성자는 몇개?, 필드는?, 메서드는?, ...
		//	- 풀 패키지 명으로 나옴
		Class<Person> personClassInfo = Person.class;
		System.out.println(personClassInfo.getName());//test02_class_reflection.Person
		System.out.println(personClassInfo.isInterface());
		System.out.println(Arrays.toString(personClassInfo.getConstructors()));
	}
}
