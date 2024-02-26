package test09_binding_test;


class Parent {
    String x = "parent x";
    
    public void method() {
        System.out.println("parent method.");
    }
}

class Child extends Parent{
    String x = "child x";
    
    @Override
    public void method() {
        System.out.println("child method.");
    }
}

public class BindingTest {
    
    public static void main(String[] args) {
        Parent a = new Parent();//parent x
        Child b = new Child();//parent method.
        
        System.out.println(a.x);
        a.method();
        
        //Hiding
        System.out.println(b.x);//child x
        //Overriding
        b.method();//child method.
        
        
        //다형성
        Parent c = new Child();
        c.method();//child method.
        System.out.println(c.x);//parent x
        //실제 객체가 child이므로 행위는 child의 행위를 할 것
        
        //동적 바인딩
        //실제 객체의 행위가 나온다 -> 다형성
        //멤버메서드 -> 부모의 관점에서라도 자식에서 재정의한 행위 발생
        //멤버 변수는 다형성을 따르지 않는다. -> 부모의 관점에서 보면 부모의 것을 참조
        
    }

}
