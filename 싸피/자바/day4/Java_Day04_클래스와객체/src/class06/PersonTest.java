package class06;

public class PersonTest {
    public static void main(String[] args) {
//        Person p = new Person();//기본 생성자를 호출
//        p.age = 45;//멤버 변수의 초기화 => 생성자.
//        p.name= "Yang";
//        p.hobby="Youtube";
    	Person p = new Person("kim",27,"java");
    	p.info();
    	Person p2 = new Person("kin",30);
    	p2.info();
        
}
}
