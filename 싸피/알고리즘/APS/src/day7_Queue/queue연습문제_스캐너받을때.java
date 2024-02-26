package day7_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//사람 객체 생성을 위한 클래스 선언
	class newPerson{
		int num;//사람 번호
		int cnt;//받을 사탕 개수
		public newPerson(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

public class queue연습문제_스캐너받을때 {
	
	
	public static void main(String[] args) {
		//큐 선언 -> 타입은 Person
		Queue<newPerson> line = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int N = 20; //사탕의 총 개수
		line.offer(new newPerson(sc.nextInt(),1));//받을 개수 1개부터 시작(번호는 증가함)
		while(N>0) {//사탕이 다 소요될 때까지 반복
			newPerson p = line.poll();//객체 생성, 받아서 나감.
			N -= p.cnt; //전체 사탕에서 사람이 받아간 만큼 뺀다.
			if(N<=0) {
				System.out.println(p.num+"번이 마지막 마이쮸를 받았습니다.");
				break;
			}else {
				System.out.println(p.num+"번이 "+p.cnt+"개의 마이쮸를 받았습니다.");
				System.out.println("마이쮸가 "+N+ "개 남았습니다.\n");
				p.cnt++;//받고나서 다음에 받을 개수 한개 증가함
				line.offer(p);//받고 나서 다시 줄섬
				line.offer(new newPerson(sc.nextInt(),1));
			}
		}
	}

}

