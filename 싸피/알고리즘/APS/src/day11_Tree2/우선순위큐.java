package day11_Tree2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 우선순위큐 {

	public static void main(String[] args) {
		//Comparator활용 가능
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			//뒤에 숫자로 앞에 숫자를 빼줌으로써 내림차순으로 바뀜
			//뒤가 앞보다 크면 차이가 양수이므로 자리 바뀜
			//차이가 음수면 그대로 -> 앞숫자가 더 크다는 뜻
			@Override
			public int compare(Integer a, Integer b) {
				// Integer도 상수풀이 존재함
				// 값이 같더라도 비교가 안될 수 있음
				// == 이 잘 안먹을 수 있음
				// 그래서 b-a 나 a-b로 함
				return b-a;
			}
			
		});
		pq.add(12);
		pq.add(23);
		pq.add(32);
		pq.add(8);
		pq.add(73);
		
		System.out.println(pq.poll());//73
		System.out.println(pq.poll());//32
		System.out.println(pq.poll());//23
		System.out.println(pq.poll());//12
		System.out.println(pq.poll());//8
		
		/*기본 순서는 오름차순
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(12);
		pq.add(23);
		pq.add(32);
		pq.add(8);
		pq.add(73);
		
		System.out.println(pq.poll());//8
		System.out.println(pq.poll());//12
		System.out.println(pq.poll());//23
		System.out.println(pq.poll());//32
		System.out.println(pq.poll());//73
		*/
		/*음수를 붙이면 내림차순 확인 가능
		pq.add(-12);
		pq.add(-23);
		pq.add(-32);
		pq.add(-8);
		pq.add(-73);
		
		System.out.println(-pq.poll());//73
		System.out.println(-pq.poll());//32
		System.out.println(-pq.poll());//23
		System.out.println(-pq.poll());//12
		System.out.println(-pq.poll());//8
		*/
		
	}

}
