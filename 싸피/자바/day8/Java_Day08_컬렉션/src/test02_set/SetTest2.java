//객체의 집합
//Set에서 중복을 판단하는 요소
//1.hashCode()가 일치하는지
//2.equals() 오버라이드
//객체는 new로 새로 생성하면 hashCode값이 다름
//Object로부터 물려받은 계산 로직이 아닌 String에서 오버라이드 한 로직을 쓰겠다.
package test02_set;

import java.util.HashSet;
import java.util.Set;

public class SetTest2 {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<Person>();
        
        Person p1 = new Person("사람1", "111111");
        Person p2 = new Person("사람1", "111111");
        
        set.add(p1);
        set.add(p2);
        
        System.out.println(p1.hashCode());//1159190947
        System.out.println(p2.hashCode());//925858445
        
        // 사람이 한 사람만? 아니면 두 사람?
        System.out.println(set);
    }
}
