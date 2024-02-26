package java04_control;

public class Ctrl02_If_Else {
	public static void main(String[] args) {
    	 int n = 15;
         if(n > 10) {
             System.out.println("블록 내부를 수행한다.");
         }//조건식이 참이므로 문장 실행
         else { System.out.println("else블록 실행");
         }       
         int n2 = 8;
         if(n2 > 10) {
             System.out.println("블록 내부를 수행한다.");
         }
         else { System.out.println("else블록 실행");
         } //조건식이 거짓이므로 문장 실행 
        
    }
}
