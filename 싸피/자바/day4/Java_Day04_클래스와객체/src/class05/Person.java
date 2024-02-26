package class05;

public class Person {
	String name;
	int age;
	String hobby;

//메소드 오버로딩
//메소드 명은 일치
//파라미터의 개수, 순서, 타입이 다를 때
//똑같은 이름으로 메소드 여러개 생성 가능
//순서가 다를 때는 타입이 달라야함
//리턴타입만 다른 것은 의미 없음

//int
//long
//String, int
	void study(int time) {
		System.out.println(time + "시간 만큼 공부했습니다.(1)");
	}
	void study(long time) {
		System.out.println(time + "시간 만큼 공부했습니다.(2)");
	}


	void study(String subject, int time) {
		System.out.println(subject + "를 " + time + "시간 공부합니다.(3)");
	}
}