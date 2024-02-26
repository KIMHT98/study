//Set
//1.집합
//2.중복 허용X
//3.순서 보장X

package test02_set;

import java.util.HashSet;
import java.util.Set;

public class SetTest1 {
    public static void main(String[] args) {
    	//HashSet
    	//-Hashtable로 구성 -> 성능면에서 우수
    	Set<String> set = new HashSet<>();
    	set.add("김싸피");
    	set.add("나싸피");
    	set.add("박싸피");
    	set.add("이싸피");
    	set.add("최싸피");
    	set.add("박싸피");
    	
    	System.out.println(set);//[김싸피, 나싸피, 박싸피, 최싸피, 이싸피]
    							//넣은 순서대로 안되고 랜덤
    							//중복된 값은 하나만 들어감
    }
}  
