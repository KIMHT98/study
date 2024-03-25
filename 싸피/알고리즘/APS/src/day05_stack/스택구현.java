package day05_stack;

public class 스택구현 {

	static int[] stack = new int[5];
	static int top = -1;

	public static void main(String[] args) {
		push(1);
		int data1 = pop();
		int data2 = pop();
		System.out.println(data1);
		System.out.println(data2);
	}

	// 스택이 비었는지 확인 : isEmpty
	public static boolean isEmpty() {
		return top == -1;// ? true:false
	}

	// 스택이 찼는지 확인 : isFull
	public static boolean isFull() {
		return top == stack.length - 1;// ? true:false;
	}

	// 삽입 : push
	public static void push(int data) {
//		stack[top+1]=data;
//		top++;
		if (isFull()) {
			System.out.println("더이상 추가할 수 없습니다.");
			return;
		}
		stack[++top] = data;
	}

	// 삭제 : pop
	public static int pop() {
		if (isEmpty()) {
			System.out.println("더이상 뽑을 수 없습니다.");
			return -9999999;
		} else
			return stack[top--];
	}
}
