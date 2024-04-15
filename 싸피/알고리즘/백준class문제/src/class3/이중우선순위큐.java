package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
	static int minMax;
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (minMax == 1) return o2-o1;
				return o1-o2;
			}
		});
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			minMax = 1;
			for(int n=0;n<N;n++) {
				String str = br.readLine();
				char method = str.charAt(0);
				int num = Integer.parseInt(str.substring(str.lastIndexOf(" ")+1));
				if(method == 'I')pq.add(num);
				else {
					minMax = num;
					if(!pq.isEmpty()) {
						pq.poll();
					}
				}
			}
			if(pq.isEmpty()) {
				System.out.println("EMPTY");
			}else {
				minMax= 1;
				System.out.print(pq.poll()+" ");
				minMax=-1;
				System.out.print(pq.poll());
				System.out.println();
			}
		}
	}

}
