package test01_object;

import com.google.gson.Gson;

public class test1 {

	public static void main(String[] args) {
		//외부 라이브러리를 인식시키는 방법
		//1. JRE System Library폴더에 끼워넣기(권장X)
		//2. 프로젝트 폴더 외부에 존재하는 jar파일 인식시켜주기
		//	 - 프로젝트를 다른 곳으로 옯기면 인식이 안될 수도 있다.
		//3. 프로젝트 폴더 내부에 jar파일을 복사한 다음, 인식
		//	 (선택 사항) lib폴더 만들기 
		//	 (1)jar파일을 프로젝트 내부에 복사
		//	 (2)프로젝트 우클릭 > Build Path > Configure Build Path
		//	 (3)Library 탭에서 Add Jars.
		//	 (4)다하면 Regerenced Libraries생성됨.
		//4. Maven프로젝트로 바꾼 후 pom.xml dependency 추가하기(스타트캠프때 했던 방법)
		
		Gson gson = new Gson();
		
		Person p = new Person("Yang",45);
		
		System.out.println(p);//Person [name=Yang, age=45]
		
		//자바 객체 -> Json문자열
		String str = gson.toJson(p);
		System.out.println(str);//{"name":"Yang","age":45}
	}

}
