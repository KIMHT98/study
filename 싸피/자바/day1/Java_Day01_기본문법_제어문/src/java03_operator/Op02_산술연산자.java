package java03_operator;

public class Op02_산술연산자 {
    public static void main(String[] args) {
    	 // 주석에 올바른 실행 결과 값을 채워 넣으시오.
    	
        int a = 10;
        int b = 6;
        //정수끼리의 나눗셈 -> 소수점 이하를 버림
        System.out.println(a + b); // 16
        System.out.println(a - b); //  4
        System.out.println(a * b); // 60
        System.out.println(a / b); // 1
        System.out.println(a % b); // 4
        
        //정수와 실수의 연산 -> 실수
        System.out.println((double)a / b); // 1.6666666666666667
        System.out.println(a / (double)b); // 1.6666666666666667
        //먼저 정수로 계산 후 실수화
        System.out.println((double)(a / b)); // 1.0
        
        double c = 2.3;
        
        System.out.println(a / c); // 4.347826086956522
        System.out.println(a / (int) c); // 5
        
        
    }
}
