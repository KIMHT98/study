package class05;

public class PersonTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.age = 45;
        p.name= "Yang";
        p.hobby="Youtube";
        
        //형변환 없이 호출
        p.study(10);
        
        //묵시적 형변환
        //전달할 인자가 묵시적 형변환이 가능한 경우
        //묵시적 형변환이 가능한 메소드가 호출된다.
        //묵시적 형변환이 안되면 명시적 형변환을 하던지 새로운 메소드를 만들어야함
        p.study((byte) 1);
        
        p.study(100L);
        p.study("java",10);
    }
}
