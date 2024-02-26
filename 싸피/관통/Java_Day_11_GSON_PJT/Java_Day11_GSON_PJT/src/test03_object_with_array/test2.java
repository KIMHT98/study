package test03_object_with_array;

import com.google.gson.Gson;

public class test2 {
	public static void main(String[] args) {
		String str = "{\"name\":\"Kim\",\"age\":27,\"hobbies\":[\"Youtube\",\"Golf\"]}";
		
		
		Gson gson = new Gson();
		Person p =gson.fromJson(str, Person.class);
		System.out.println(p);
	}
}
