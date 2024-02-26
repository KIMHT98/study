package test08_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest2 {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

     
        persons.add(new Person("BBB", 22));
        persons.add(new Person("BBB", 23));
        persons.add(new Person("AAA", 23));
        persons.add(new Person("AAA", 11));
        
        System.out.println(persons);
        
        //Comparator 클래스를 만들어도 되는데 귀찮아..
        //람다 표현식 쓰자!
        //-이름이 없는 함수
        //-파라미터로 전달하기 위한 함수
        //-주로 길이가 짧을 때 사용
        
        //문법
        //(매개변수..) -> {함수 본문 내용}
        //매개변수가 없는 경우 ()
        //매개변수 한개면 괄호 생략 가능
        //본문 내용이 한문장인 경우 중괄호 생략 가능
        //매개변수에 타입 생략 가능
        
        Collections.sort(persons, (Person o1, Person o2)->{
        	if (o1.name.equals(o2.name)) {
        		return o1.age - o2.age;
        	}
        	return o1.name.compareTo(o2.name);
        });
       
        System.out.println(persons);
         
    }
}
