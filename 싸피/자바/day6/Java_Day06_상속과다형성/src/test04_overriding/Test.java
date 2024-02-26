package test04_overriding;

public class Test {
    public static void main(String[] args) {
        Person p = new Person("Hong",25);
        // p.
        Student st = new Student("yang",45, "computer");
        // st. 
        st.eat();
    }
}
