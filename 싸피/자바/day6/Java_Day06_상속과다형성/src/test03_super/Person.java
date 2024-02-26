package test03_super;

public class Person {
    String name;
    int age;
    
    public Person(String name, int age) {
    	// 생성자의 첫줄에는 super();생략되어 있다.
    	// super() : 부모 생성자 호출 -> 첫 줄에 와야함
    	// this() : 자신의 다른 생성자 호출 -> 첫 줄에 와야함
    	// => 둘 중 하나만 사용 가능
    	//super(); //Object(); // 최종적으로 Object()기본생성자를 호출하게 되어 있다.
    	this.age = age;
    	this.name = name;
    	System.out.println("person의 생성자 입니다.");
    }
    public void eat() {
        System.out.println("음식을 먹는다.");
    }
}
