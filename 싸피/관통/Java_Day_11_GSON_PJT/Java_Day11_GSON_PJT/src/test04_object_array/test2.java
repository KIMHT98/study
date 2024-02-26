package test04_object_array;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class test2 {

	public static void main(String[] args) {
		String str = "[{\"name\":\"yang\",\"age\":30},{\"name\":\"kim\",\"age\":30},{\"name\":\"lee\",\"age\":30}]";
		// 객체 배열의 문자 -> 객체의 배열
		Gson gson = new Gson();
		
		Person[] arr = gson.fromJson(str, Person[].class);
		
		Class<Person[]> info = Person[].class;
		
		System.out.println(Arrays.toString(arr));
		
		//먼저 배열로 받은 다음에 리스트로 변환 추천
		//바로 리스트로 받으려면? -> Gson라이브러리. TypeToken
		
		//java.lang.reflect <- meta 정보
		Type listType = new TypeToken<ArrayList<Person>>() {}.getType();
		
		ArrayList<Person> list = gson.fromJson(str, listType);
		list.add(new Person("park",29));
		System.out.println(list);
	}

}
