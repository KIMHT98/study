package day7_Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 퍼펙트셔플 {

	public static void main(String[] args) throws IOException {
		Queue<String> odd = new LinkedList<>();//홀수번째에 위치할 카드들
		Queue<String> even = new LinkedList<>();//짝수번째에 위치할 카드들
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			int n = Integer.parseInt(br.readLine());
			String[] deck = br.readLine().split(" ");//카드 리스트
			String[] result = new String[n];
			for(int i=0;i<(n-1)/2+1;i++) {
				odd.offer(deck[i]);//카드가 홀수개인 경우 홀수번째가 하나 더 많음 
			}					   //카드덱에서 앞 절반이 홀수번째에 오게 됨
			for(int i=(n-1)/2+1;i<n;i++) {
				even.offer(deck[i]);//카드덱에서 뒤 절반이 짝수번째에 오게 됨
			}
			for(int i=0;i<n;i++) {
				if(i%2==0)
					result[i] = odd.poll();//홀수번째
				else
					result[i] = even.poll();//짝수번째
			}
			for(int i =0;i<n;i++) {
				sb.append(result[i]).append(" ");
			}
			System.out.println(sb);
		}

	}

}
