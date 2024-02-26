//Map
//-사전과 같은 자료구조
//-키 & 값의 쌍으로 저장
//-키로 구별(중복 X), 값(중복 가능)
//-키가 마치 set처럼 순서가 보장되지 않음
//값에 리스트를 넣으면 하나의 키에 값이 여러개가 되도록 할 수 있음
package test03_map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        
        //값을 넣을 때 put사용
        map.put("서울5반", "현경찬");
        map.put("서울6반", "옥진석");
        map.put("서울7반", "육예진");
        map.put("서울8반", "서경덕");
        map.put("대전3반", "허지영");
        map.put("대전4반", "김범규");
        System.out.println(map);
         
        //값을 꺼낼 때는 key가 인덱스 역할 -> get(키)
        System.out.println(map.get("대전3반"));//허지영
         
        //값을 바꿀 수 있음
        map.put("서울8반", "김현태");
        System.out.println(map);//8반 반장이 김현태로 바뀜
        
        //containsKey(키) or containsValue(값)으로 해당 내용이 있는지 확인 가능
        System.out.println(map.containsKey("구미1반"));//false
        System.out.println(map.containsValue("김현태"));//true
        
        //맵의 순회
        //1. KeySet()
        for(String key: map.keySet()) {
        	System.out.printf("%s : %s \n", key, map.get(key));
        }
        //2. entrySet()
        for(Map.Entry<String,String> entry : map.entrySet()) {
        	System.out.println(entry.getKey()+" : "+ entry.getValue());
        }
        
        }
        
        
        
    }

