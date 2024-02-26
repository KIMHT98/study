package day11_Tree2;
import java.util.Arrays;
import java.util.Scanner;

public class 힙 {
	static int[] heap;
	static int heapsize;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			sc.nextLine();
			heap = new int[n + 1];
			System.out.print("#" + t + " ");
			for (int i = 0; i < n; i++) {
				String command = sc.nextLine();
				if (command.equals("2")) {
					System.out.print(removenode() + " ");
				} else {
					addnode(Integer.parseInt(command.split(" ")[1]));
				}
//				System.out.println(Arrays.toString(heap));
			}
			heapsize = 0;
			System.out.println();
		}
	}

	static void swap(int a, int b) {
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}

	static void addnode(int data) {
		heap[++heapsize] = data;

		int ch = heapsize;
		int p = ch / 2;

		while (p > 0 && heap[p] < heap[ch]) {
			swap(p, ch);
			ch = p;
			p = ch / 2;

		}

	}

	static int removenode() {
		int Item = heap[1];
		if (heapsize <= 0) {
			return -1;
		} else {
			heap[1] = heap[heapsize--];
			int p = 1;
			int ch = p * 2;
			if(ch+1<=heapsize && heap[ch] < heap[ch+1]) {
				ch++;
			}

			while(ch<=heapsize && heap[p]<heap[ch]) {
				swap(p,ch);
				
				p = ch;
				ch = p *2;
				if(ch+1<=heapsize && heap[ch] < heap[ch+1]) {
					ch++;
				}
			}
			return Item;
		}
	}

}
