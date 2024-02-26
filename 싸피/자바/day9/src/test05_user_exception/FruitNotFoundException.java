package test05_user_exception;
//Exception을 상속받으면 -> checkedException이 됨
//RuntimeException을 상속받으면 -> unchecked exception이 됨
public class FruitNotFoundException extends Exception {
	//생성자
	public FruitNotFoundException(String name) {
		super(name +"에 해당하는 과일은 없습니다.");
		//문자열을 넣어서 에러메시지로 출력해줌
	}
}
