package test03_super;

public class Test {
    public static void main(String[] args) {
        Person p = new Person("Hong",25);
        // p.
        Student st = new Student("yang",45, "computer");
        // st. 상속을 받아서 몇몇 변수 및 메소드는 Person 클래스에서 물려받음
        // 부모 클래스의 생성자가 먼저 호출 -> super()가 가장 위에 있어서 그런듯
        // 힙 영역에 object -> person -> student 순으로 생성
    }
}
