package class06;

public class Person {
	String name;
	int age;
	String hobby;

		//생성자: 클래스명과 일치,
		//반환형이 없다.
		//기본 생성자()
	void info() {
    	//멤버 변수에 바로 접근 가능
    	System.out.println("이름은 "+name+"이고, 나이는 "+age+"세 취미는 "+hobby+"입니다.");
    }
	//파라미터가 있는 생성자 => 멤버 변수의 초기화에 사용
	//this는 멤버변수와 파라미터를 구분하기 위해서 사용
	Person(String name, int age, String hobby){
		// this.객체가 가지고 있는 매개변수
		// 멤버 변수 또는 멤버 메서드 접근에 사용.
		// this : 객체 자기 자신에 대한 참조.
		this.name = name;
		this.age = age;
		this.hobby = hobby;
		//this를 첫줄에 사용하면, 다른 생성자를 호출할 수 있음
	}
	//생성자 오버로딩
	//매개변수의 타입, 개수, 순서가 달라지면 오버로딩 가능
	//매개변수의 이름만 다른 것은 소용X
	Person(String n, int a){
//		name = n;
//		age = a;
//		hobby = "따로 없음";
		this(n,a,"따로 없음");
	}
	
	Person(int a){
		this("무명",a,"취미 없음");
	}
}