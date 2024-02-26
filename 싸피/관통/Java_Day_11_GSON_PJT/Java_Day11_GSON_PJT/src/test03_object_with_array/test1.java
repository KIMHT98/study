package test03_object_with_array;

import com.google.gson.Gson;

public class test1 {
	public static void main(String[] args) {
		Person p = new Person("Kim",27, new String[] {"Youtube","Golf"});
		
		Gson gson = new Gson();
		String str = gson.toJson(p);
		System.out.println(str);
	}
}
