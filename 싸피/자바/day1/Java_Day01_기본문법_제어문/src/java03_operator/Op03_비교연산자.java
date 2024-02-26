package java03_operator;

public class Op03_비교연산자 {

    public static void main(String[] args) {
    	 // 주석에 올바른 실행 결과 값을 채워 넣으시오.
        int a = 10;
        
        System.out.println(a > 10); // f
        System.out.println(a <= 10); // t
        System.out.println(a >= 10); // t
        System.out.println(a == 10); // t
        System.out.println(a != 10); // f
        
        // 문자열은 어떻게 비교하는가?
        String c=  "Hi";
        String d = "Hi";
        String e = new String("Hi");
        
        //자바에서 문자열의 비고는 ==, != 연산자로 안함
        // 문자열에서 ==, 1= : 참조값(주소)비교
        // 문자열에서 .equals : 값 비교
        // 문자열 값이 같으면 주소값 같음 -> new쓰면 달라짐
        System.out.println(c == d); // t
        System.out.println(c == e); // f
        System.out.println(c.equals(e)); // t
        
    }
}
