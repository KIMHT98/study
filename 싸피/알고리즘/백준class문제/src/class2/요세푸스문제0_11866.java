package class2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스문제0_11866 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		List<Integer> li = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			q.offer(i);
		}int cnt = 1;
		while(!q.isEmpty()) {
			//k번 째의 사람이 나가리
			if(cnt%k==0) {
				li.add(q.poll());
				//이후 출력을 위해서 리스트에 추가
				cnt++;
			}else {
				q.add(q.poll());
				//k번째가 아니면 계속 순회
				cnt++;
			}
			
			
		}
		System.out.println(li.toString().replace('[', '<').replace(']','>'));

	}

}
