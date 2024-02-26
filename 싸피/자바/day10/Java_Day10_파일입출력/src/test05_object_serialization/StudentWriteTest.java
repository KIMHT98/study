package test05_object_serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//직렬화
public class StudentWriteTest {

	public static void main(String[] args) {
		Student s = new Student("김현태","8반");//힙영역에 객체 생성됨
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"))){
			oos.writeObject(s);
			System.out.println("끝");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
