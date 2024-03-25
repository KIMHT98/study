package day04_String;

public class String01_문자열 {

	public static void main(String[] args) {
		//리터럴 방식
		String str1 = "abc";
		//new 키워드 사용
		//new를 사용했기 때문에 문자열 상수풀이 아닌 그냥 힙영역에 생성
		String str2 = new String("abc");
		//JVM의 메모리 구조에서 문자열이 선언되면 힙영역의 문자열 상수풀에 생성
		//이거는 리터럴 방식만
		//같은 내용의 문자열이 리터럴 방식으로 선언되면 문자열 상수풀에 같은 내용이 있는지 확인
		//같은 내용이 있으면 얘의 주소값을 할당해서 리터럴 방식으로 선언된 것들을
		//비교하면 같다고 나오는 것임.
		String str3 = "abc";
		System.out.println(str1);
		System.out.println(str2);
		//참조 자료형의 경우 -> 해시코드를 비교
		//문자열의 내용을 비교하려면 equals이용
		System.out.println(str1==str2);//false
	}

}
