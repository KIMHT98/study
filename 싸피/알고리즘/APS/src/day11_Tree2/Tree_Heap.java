package day11_Tree2;

import java.util.Arrays;

public class Tree_Heap {
	static int[] heap = new int[7];
	static int heapSize;
	
	public static void main(String[] args) {
		heapPush(55);
		heapPush(56);
		heapPush(54);
		heapPush(32);
		heapPush(1);
		heapPush(11);
		
		System.out.println(Arrays.toString(heap));
		
		System.out.println(heapPop());
		System.out.println(Arrays.toString(heap));
		System.out.println(heapPop());
		System.out.println(Arrays.toString(heap));
		System.out.println(heapPop());
		System.out.println(Arrays.toString(heap));
		System.out.println(heapPop());
		System.out.println(Arrays.toString(heap));
		System.out.println(heapPop());
		System.out.println(Arrays.toString(heap));
		System.out.println(heapPop());
		System.out.println(Arrays.toString(heap));
		
		
		
	}
	//swap메소드
	static void swap(int a, int b) {
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}
	
	//삽입
	static void heapPush(int data) {
		//마지막 위치에 노드 추가
		heap[++heapSize] = data;
	
		//부모 노드와 비교하면서 swap
		int chidx = heapSize;//자식 노드 위치
		int pidx = chidx / 2; //부모 노드 위치
		
		//부모와 자식 값 비교하여 정렬 조건 만족시킬때까지 반복
		//계속 비교하다가 자식이 루트로 오면 부모는 0이 되는데 
		//이걸 방지하기 위해 부모 위치가 0보다 클때로 조건 둠
		while(pidx>0 && heap[pidx]<heap[chidx]) {
			// 값 swap
			swap(chidx,pidx);
			chidx = pidx;//위치도 바꿔줌
			pidx = chidx / 2;//바뀌고 나서의 부모 노드 위치
		}
	}
	//삭제
	static int heapPop() {
		//루트에 있는 원소 제거
		int popItem = heap[1];
		//마지막에 있는 원소를 루트로 옮기기
		heap[1] = heap[heapSize--];
		
		int pidx = 1;//옮겨진 원소의 위치(루트)
		int chidx = pidx * 2;//그 원소의 자식 위치
		
		//리프노드로 가면 자식이 없음
		//자식노드 위치가 heapSize보다 커지면 멈춤
		while(chidx <= heapSize && heap[pidx] < heap[chidx]) {
			if(chidx + 1 <= heapSize && heap[chidx] < heap[chidx+1]) {
				chidx++;
			}
			//자식이 더 크면 swap
			swap(pidx,chidx);
			
			pidx = chidx;
			chidx = pidx * 2;
			
		}
		return popItem;
	}
	
	
}
