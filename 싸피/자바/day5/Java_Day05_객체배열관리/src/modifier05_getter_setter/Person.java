package modifier05_getter_setter;
//접근자와 설정자를 이용한 캡슐화 구현
public class Person {
//1. 멤버변수(데이터 필드)는 외부에서 접근 못하도록 private로 막는다.
  private String name;
  private int age;
  private String hobby;
 
//2. 합법적인 통로를 열어준다.
  //- 접근자 & 설정자 => 메소드
  //접근자(getter)
  //public 자료형 get멤버변수명() {
  //	return 멤버변수;
  //}
  //메소드명은 카멜케이스
  
  public String getName() {
	  return name;
  }
  
  //설정자(setter)
  //public void set멤버변수명(자료형 매개변수) {
  //	멤버변수 = 매개변수값;
  //}
  
  public void setName(String name) {
	  this.name= name;
  }

public int getAge() {
	return age;
}

public void setAge(int age) {
	if(age<0) {
		System.out.println("나이는 양수여야됨");
		return;//함수를 종료하겠다/.
	}
	this.age = age;
}

public String getHobby() {
	return hobby;
}

public void setHobby(String hobby) {
	this.hobby = hobby;
}
  
  //우클릭 -> Source -> Generate getter and setter로 자동완성 가능
  
    
}
