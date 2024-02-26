package day11_Tree2;

import java.util.PriorityQueue;

class Person implements Comparable<Person>{
	String name;
	int age;
	
	Person(String name, int age){
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {
		if(this.age == o.age) {
			return this.name.compareTo(o.name);
		}
		return this.age - o.age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

public class 우선순위큐_사람비교 {

	public static void main(String[] args) {
		//Person은 비교 기준이 없기 때문에 그냥 돌리면 예외 발생
		//기준을 만들어줘야 함
		//1.Comparator을 pq생성자에 넣어주기(람다식도 가능)
		//2.Person이 Comparable을 구현하면 됨
		PriorityQueue<Person> pq = new PriorityQueue<>();
		
		pq.add(new Person("김",20));
		pq.add(new Person("이",25));
		pq.add(new Person("박",30));
		pq.add(new Person("최", 20));
		pq.add(new Person("강",26));
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		
	}

}
