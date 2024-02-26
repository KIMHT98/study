package test04_abstract_method;

//추상메서드를 하나라도 가지고 있으면 클래스도 추상 클래스이다.
//클래스에도 abstract 키워드를 붙여줘야함.
//추상메서드가 없어도 abstract 붙일 수 있다. -> 객체 생성을 안하겠다는 뜻.
public abstract class Chef {
    String name;
    int age;
    String speciality;
    
    public void eat() {
        System.out.println("음식을 먹는다.");
    }
    
    //부모클래스의 메서드를 삭제하는 것이 아니라
    //추상메서드로 만든다.
    public abstract void cook();//실행 구문(구현부)를 삭제하고 세미콜론으로 대체
    							//abstract 키워드를 붙임
    //1.다형성 활용 가능
    //2.자식 클래스에서 반드시 오버라이드해서 구현해야 함. (구현의 강제)
    
    
}
