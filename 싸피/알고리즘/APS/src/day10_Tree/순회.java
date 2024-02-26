package day10_Tree;

public class 순회 {
	// 트리 배열로 표현
	// 빈 노드는 0으로 표현
	static char[] tree = new char[] { '\0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 0, 0, 'H', 'I' };

	public static void main(String[] args) {
		preorder(1);// A B D E H I C F G
		System.out.println();
		inorder(1);// D B H E I A F C G
		System.out.println();
		postorder(1);// D H I E B F G C A
	}

	// 전휘 순회
	// V(현재 노드 방문)L(왼쪽 서브 트리로 이동)R(오른쪽 서브 트리로 이동)
	// 매개변수 -> 방문할 노드의 번호
	static void preorder(int i) {
		// 기저 조건
		// 인덱스가 tree의 크기를 초과하거나 노드가 빈 경우 스킵
		if (tree.length <= i || tree[i] == 0) {
			return;
		}

		// 부모 노드 방문(출력)
		System.out.print(tree[i] + " ");
		// 왼쪽 자식
		preorder(i * 2);
		// 오른쪽 자식
		preorder(i * 2 + 1);
	}

	// 중위 순회
	// L(왼쪽 서브 트리)V(부모 트리)R(오른쪽 서브 트리)
	static void inorder(int i) {
		if (tree.length <= i || tree[i] == 0) {
			return;
		}
		// 왼쪽 자식
		inorder(i * 2);
		// 부모 노드
		System.out.print(tree[i] + " ");
		// 오른쪽 자식
		inorder(i * 2 + 1);
	}

	// 후위 순회
	// L(왼쪽 서브 트리)R(오른쪽 서브 트리)V(부모)
	static void postorder(int i) {
		if (tree.length <= i || tree[i] == 0) {
			return;
		}
		// 왼쪽 자식
		postorder(i * 2);
		// 오른쪽 자식
		postorder(i * 2 + 1);
		// 부모 노드
		System.out.print(tree[i] + " ");
	}
}
