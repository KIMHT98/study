package day7_Queue;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 암호생성기 {

	public static void main(String[] args) throws IOException {
		Queue<Integer> password = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int a = Integer.parseInt(br.readLine());
			String list = br.readLine();//암호 숫자 입력
			for (int i = 0; i < 8; i++) {
				//숫자들 큐에 추가하기
				password.offer(Integer.parseInt(list.split(" ")[i]));
			}
			//처음에 1을 뺴준다
			int minus = 1;
			while (true) {
				//추가될 것은 앞에 숫자에서 minus뺸것
				int next = password.peek() - minus;
				//next가 양수이면 그대로 양수가 아니면 0 삽입
				password.offer(next >0 ? next: 0);
				//앞에 뺀 원소가 <=0이면 반복 종료
				if (password.poll() - minus <= 0)
					break;
				minus++;//마이너스 1씩 커짐
				if (minus > 5) {//5보다 커지면 사이클 종료 
					minus = 1;//다시 1부터
				}
			}
			System.out.print("#"+t+" ");
			while (!password.isEmpty()) {
				System.out.print(password.poll() + " ");
			}
			System.out.println();
		}
	}

}
