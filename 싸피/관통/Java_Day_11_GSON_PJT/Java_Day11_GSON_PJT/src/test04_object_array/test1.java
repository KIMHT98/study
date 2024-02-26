package test04_object_array;

import java.util.Arrays;

import com.google.gson.Gson;

public class test1 {

	public static void main(String[] args) {
		Person[] arr = new Person[3];
		
		arr[0] = new Person("yang",30);
		arr[1] = new Person("kim",30);
		arr[2] = new Person("lee",30);
		
		System.out.println(Arrays.toString(arr));
		
		Gson gson = new Gson();
		String str = gson.toJson(arr);
		System.out.println(str);
	}

}
