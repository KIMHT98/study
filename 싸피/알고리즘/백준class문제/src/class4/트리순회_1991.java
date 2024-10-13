package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 트리순회_1991 {
	static StringBuilder sb;

	static class Node {
		char value;
		Node left, right;

		Node(char v, Node l, Node r) {
			this.value = v;
			this.left = l;
			this.right = r;
		}

	}

	static void preorder(Node node) {
		if (node == null)
			return;
		sb.append(node.value);
		preorder(node.left);
		preorder(node.right);
	}

	static void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		sb.append(node.value);
		inorder(node.right);
	}

	static void postorder(Node node) {
		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		sb.append(node.value);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Node[] nodeArr = new Node[26];
		for(int i=0;i<26;i++) {
			nodeArr[i] = new Node((char)('A'+i),null,null);
		}
		for (int i = 0; i < n; i++) {
			String[] arr = br.readLine().split(" ");
			char value = arr[0].charAt(0);
			char left = arr[1].charAt(0);
			char right = arr[2].charAt(0);
			int idx = value-'A';
			if (left != '.') {
				nodeArr[idx].left = nodeArr[left - 'A'] == null ? new Node(left, null, null) : nodeArr[left - 'A'];
			}
			if (right != '.') {
				nodeArr[idx].right = nodeArr[right - 'A'] == null ? new Node(right, null, null) : nodeArr[right - 'A'];
			}
		}
		preorder(nodeArr[0]);
		sb.append("\n");
		inorder(nodeArr[0]);
		sb.append("\n");
		postorder(nodeArr[0]);
		System.out.println(sb);

	}

}
