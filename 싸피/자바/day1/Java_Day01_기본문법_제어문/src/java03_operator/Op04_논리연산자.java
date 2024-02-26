package java03_operator;

public class Op04_논리연산자 {
	public static void main(String[] args) {
		 // 주석에 올바른 실행 결과 값을 채워 넣으시오.

		System.out.println(true && true); //t
		System.out.println(true && false); //f
		System.out.println(false && true); //f
		System.out.println(false && false); //f

		System.out.println(true || true); //t
		System.out.println(true || false); //t
		System.out.println(false || true); //t
		System.out.println(false || false); //f

		int a = 10;
		int b = 20;
		//short circuit evaluation(단측 평가)
		// &&연산의 경우 -> 앞이 false면 전체가 false
		// -> 뒤의 계산은 고려X
		System.out.println(a > b && a++ > b); //f
		System.out.println(a); //10
		System.out.println(a < b && a++ < b); //t
		System.out.println(a); //11
		
		//||연산 : 앞이 true -> 전체 true -> 뒤의 계산 고려X
		System.out.println(a > b || a++ > b); //f
		System.out.println(a); //12
		System.out.println(a < b || a++ < b); //t
		System.out.println(a); //12

		System.out.println("-----");

		a = 10;
		b = 20;

		System.out.println(a > b & a++ > b); //
		System.out.println(a); //
		System.out.println(a < b & a++ < b); //
		System.out.println(a); //

		System.out.println(a > b | a++ > b); //
		System.out.println(a); //
		System.out.println(a < b | a++ < b); //
		System.out.println(a); //

	}
}
