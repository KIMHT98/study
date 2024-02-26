package test06_final;

public class Test {
    public static void main(String[] args) {
        Person p = new Person("Hong",25);
        // p.
        Student st = new Student("yang",45, "computer");
        // st. 
        st.eat();
        
        Student st2 = new Student("yang",29,"math");
        
      //Obect의 toString은 기본적으로 참조값을 알려줌
        System.out.println(p.toString());
      //클래스에서 오버라이딩 하여 출력값을 내용으로 변경 가능  
        System.out.println(st.toString());
        
        System.out.println(st == st2);
        System.out.println(st.equals(st2));
        
    }
}
