package class04;

public class PersonTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.age = 45;
        p.name= "Yang";
        p.hobby="Youtube";
        
        p.info();// 객체 생성 후에 객체의 이름으로 접근
        Person.hello();//객체 생성 없이 클래스 이름으로 바로 접근 ->static이용
    }
}
