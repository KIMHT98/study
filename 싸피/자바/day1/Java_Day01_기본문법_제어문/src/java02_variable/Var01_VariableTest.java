package java02_variable;

public class Var01_VariableTest {
    public static void main(String[] args) { 
        
        int age; //변수명은 대소문자 구별 Age와 다름
        int _age;//_또는 $를 변수 이름에 사용 가능
        int $age$;//이외의 문자는 불가능
        int money = 10000;//변수 선언과 할당은 같이 가능
        
        int a;//변수 선언
        
        a = 100; //변수 할당
        
        int n1 = 10;
        int n2 = n1;
        
        System.out.println(n1);//10
        System.out.println(n2);//10
        
        n1 = 20;
        System.out.println(n1);//20
        System.out.println(n2);//10
    }
}
