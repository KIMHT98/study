package test03_object_with_array;

import java.util.Arrays;

public class Person {
    private String name;
    private int age;
    private String[] hobbies;
    
    
    
    
    public Person(String name, int age, String[] hobbies) {
        super();
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

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
        return "Person [name=" + name + ", age=" + age + ", hobbies=" + Arrays.toString(hobbies) + "]";
    }

    
    
    
    
    
}
