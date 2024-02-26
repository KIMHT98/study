package modifier05_getter_setter;

public class PersonTest {
    public static void main(String[] args) {
        Person p = new Person();
        //p.name = "yang"; -> 멤버변수에 직접 접근 불가(private이라서)
        //=>위 방법은 값을 할당하는 것밖에 할 수 없으
        //=>기타 로직(검증 로직)의 추가가 불가능
        p.setName("yang");
        p.setAge(-10);
        System.out.println(p.getAge());
    }
}
