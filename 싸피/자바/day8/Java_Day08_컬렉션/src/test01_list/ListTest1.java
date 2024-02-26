package test01_list;

import java.util.ArrayList;
import java.util.List;

public class ListTest1 {
    public static void main(String[] args) {
    	//<>은 제네릭으로 타입을 지정해줌
    	List<String>names = new ArrayList<>();
    	//원소ㅗ 추가
    	names.add("김현태");
    	names.add("김싸피");
    	names.add("이싸피");
    	names.add("박싸피");
    	names.add("최싸피");
    	names.add("김싸피");
    	System.out.println(names);
    	
    	//비어있는지 체크
    	System.out.println(names.isEmpty());//false
    	
    	//값 삭제
    	names.remove(0);//인덱스 활요
    	System.out.println(names);
    	
    	names.remove("김싸피");//값 활용
    	System.out.println(names);//중복된 값의 경우 앞에꺼부터 삭제됨.
    	
    	names.clear();//전부 삭제
    	System.out.println(names);
    	
    	//삭제 시 주의 사항
    	names.clear();
    	
    	names.add("학생1");
    	names.add("학생1");
    	names.add("학생2");
    	System.out.println(names);//[학생1, 학생1, 학생2]
    	
    	//학생1을 다 지우겠다.
    	for(int i = 0; i<names.size();i++) {
    		if(names.get(i).equals("학생1"))
    			names.remove(i);
    	}
    	System.out.println(names);//다 안지워짐->[학생1, 학생2]
    	
    	names.clear();
    	
    	names.add("학생1");
    	names.add("학생1");
    	names.add("학생2");
    	System.out.println(names);//[학생1, 학생1, 학생2]
    	
    	//반복 과정을 반대로 한다.
    	//인덱스가 점점 줄어들게
    	for(int i = names.size()-1;i>=0;i--) {
    		if(names.get(i).equals("학생1"))
    			names.remove(i);
    	}
    	System.out.println(names);//[학생2]
    	
    }
}
