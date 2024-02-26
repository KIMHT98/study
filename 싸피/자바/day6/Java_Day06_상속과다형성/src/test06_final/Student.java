package test06_final;

public class Student extends Person {

    String major;
    public Student(String name, int age, String major) {
    	super(name, age); //부모 클래스의 생성자 호출
    	this.major = major;
    	
    }
    
    public void study() {
        System.out.println("공부를 한다.");
        super.eat();//명시적으로 부모의 베소드를 호출하는데 사용 가능
        //super.name; //부모의 멤버변수.
    }
    
    //부모 클래스의 eat()을 그대로 사용하기 싫다!
    // => 자식 클래스에서 재정의(오버라이드)
    
    @Override //선택사항이지만 쓰는게 좋음(알려줘야지)
    //-> 매개변수 순서 , 개수, 타입이 다 같아야됨
    //->위에 알림 안쓰면 위 규칙 안지켜도 메소드가 생성이 되는데 이거는 오버라이딩이 아님
    public void eat() {
    	System.out.println("지식을 먹었다.");
    }

	@Override
	public String toString() {
		return "Student [major=" + major + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public boolean equals(Object obj) {
		
		//이름만 같으면 같은 객체라고 해보자
		return name.equals(((Student)obj).name);
	}
    
}
