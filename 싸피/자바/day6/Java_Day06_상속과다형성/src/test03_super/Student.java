package test03_super;

public class Student extends Person {

    String major;
    public Student(String name, int age, String major) {
    	super(name, age); //부모 클래스의 생성자 호출
    	this.major = major;
    	System.out.println("student의 생성자 입니다.");
    	
    }
    
    public void study() {
        System.out.println("공부를 한다.");
        super.eat();//명시적으로 부모의 베소드를 호출하는데 사용 가능
        //super.name; //부모의 멤버변수.
    }
}
