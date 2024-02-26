package class04;

public class PersonTest {
    public static void main(String[] args) {
        
    	//static변수의 접근은
    	//클래스 이름으로 바로 접근 가능
    	
    	Person.pCount = -1;
    	Person.hello();//객체 생성 없이 클래스 이름으로 바로 접근 ->static이용
    	
    	//인스턴스는 힙 메모리에 생성
    	//non-static은 객체 생성 후에만 접근 가능
    	Person p = new Person();
        p.age = 45;
        p.name= "Yang";
        p.hobby="Youtube";
        p.pCount=10;//static변수니깐 클래스 이름으로 접근하는 것이 더 좋다.
        
        Person p2 = new Person();
        p2.age = 25;
        p2.name= "Hong";
        p2.hobby="Golf";
        
    }
}
