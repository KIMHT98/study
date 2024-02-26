package test01_object;

import com.google.gson.Gson;

public class test2 {

	public static void main(String[] args) {
		String str = "{\"name\":\"Yang\",\"age\":45}";
		//JSON -> JAVA객체
		Gson gson = new Gson();
		
		//fromJson(문자열, 클래스 정보)
		Person p = gson.fromJson(str,Person.class);
		System.out.println(p);//Person [name=Yang, age=45]
				
	}

}
