package class02;

public class PersonTest {
    public static void main(String[] args) {
        //방금 만든 설계도로 객체를 생성
    	//클래스(person)는 변수(생성될 객체)의 타입으로 사용
    	//=> 클래스는 사용자 정의 자료형
    	
    	//객체 생성
    	//클래스명 변수명 = new 클래스명();
    	Person yang = new Person();
    	//yang은 인스턴스(instance)
    	//객체의 멤버변수에 접근할 때는 '.'연산자 사용
    	yang.name = "Yang";
    	yang.age = 27;
    	yang.hobby = "Java";
    	//->메모리에 yang이라는 객체가 생겨서 그 안에 값들이 저장됨
    	
    	
        
        
    }
}
