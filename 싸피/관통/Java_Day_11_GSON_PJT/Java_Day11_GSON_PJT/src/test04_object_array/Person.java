package test04_object_array;

public class Person {
    public String name;
    public int age;
    
    
    
    public Person() {
        super();
    }
    
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
    
    
    
    
    
}
