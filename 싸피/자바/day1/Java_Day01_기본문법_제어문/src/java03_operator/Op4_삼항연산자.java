package java03_operator;

public class Op4_삼항연산자 {
    public static void main(String[] args) {
    	 //랜덤 숫자 발생기 
        int num = (int) (Math.random() * 10) + 1;
        //Math.rando() -> 0~1사이의 랜덤 소수 추출
        double num2 = Math.random(); 
        
        // num이 홀수인지 짝수인지.
        System.out.println(num);
        System.out.println(num2);
        System.out.println(num % 2 == 0 ? "짝" : "홀");
        //짝수면 짝 , 홀수면 홀
    }
}
