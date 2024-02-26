package class04;

public class Person {
    //멤버 변수 : 객체가 가지고 있는 변수(데이터)
	String name;
    int age;
    String hobby;
    
    //메서드 => 클래스 안에 정의된 함수
    //멤버 메서드 : 객체가 가지고 있는 메서드.
    //객체 생성 후 객체를 통해서만 접근 가능
    void info() {
    	//멤버 변수에 바로 접근 가능
    	System.out.println("이름은 "+name+"이고, 나이는 "+age+"세 취미는 "+hobby+"입니다.");
    }
    
    //static 메서드는 객체 생성 없이 호출 가능.
    static void hello() {
    	System.out.println("hello");
    }
}
