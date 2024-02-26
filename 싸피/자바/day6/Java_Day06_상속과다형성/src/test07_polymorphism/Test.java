package test07_polymorphism;

public class Test {
    public static void main(String[] args) {

        //다형성
    	//조상클래스의 타입으로 자식 객체 참조 가능
        Student st = new Student();
        Person p = new Student();//실제 생성된 객체는 Student이지만, Person으로 취급하겠다.
        Object obj = new Student();//실제 생성된 객체는 Student이지만, Object로 취급하겠다.
        
        //st -> person과 student의 변수 메소드를 다 사용 가능
        //p -> person의 변수 및 메소드만 사용 가능
        //obj -> object의 변수 및 메소드만 사용 가능
        
        //Person에서 toString을 오버라이드 했음
        Object o2 = new Object();
        Object o3 = new Person();//다형성
        //object로 바라본다고 하더라도 실제 객체는 사람이다.
        //메소드를 실행하면 사람의 행동을 한다.
        
        
        System.out.println(o2.toString());//java.lang.Object@372f7a8d
        System.out.println(o3.toString());//Person [name=null, age=0]
        
        //부모클래스의 타입으로 자식 객체를 참조하더라도,
        //실제 객체가 자식 클래스의 객체라면,
        //자식 클래스에서 오버라이드한 메서드가 실행된다.
    }
}
