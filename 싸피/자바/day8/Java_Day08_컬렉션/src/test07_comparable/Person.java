package test07_comparable;

//컬렉션 프레임워크에서 정렬가능하도록 하려면
//Comparable 인터페이스를 구현해야함
//제네릭의 타입은 자기 자신
public class Person implements Comparable<Person> {
    String name;
    int age;
    
    
    
    
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
    
    //양수 -> 자리바꿈
    //음수 -> 그대로
    // 0 -> 그대로
	@Override
//	public int compareTo(Person o) {
//		// this(자기자신객체) o 객체랑 비교해서 -> 정수값을 반환
//		
//		//나이순으로 정렬한다면? 기본적으로 오름차순으로 해보자
//		
//		//만약 나이가 같으면 이름 순으로 하고싶음
//		//이름 : 문자열 -> string의 compareTo를 사용하면 오름차순
//		if(this.age==o.age) {
//			return this.name.compareTo(o.name);
//		}
//		
//		
//		return this.age - o.age;
//	}
	
	public int compareTo(Person o) {
		//1.이름
		//2.나이
		//이름이 같다면 나이를 비교
		if (this.name.equals(o.name)) {
			return this.age - o.age;
		}
		return this.name.compareTo(o.name);
	}


    
}
