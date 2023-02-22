import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		Node root = new Node(1);
		Node left = new Node(2);
		Node right = new Node(3);
		List<Node> children = new ArrayList<>();
		children.add(left);
		children.add(right);
		root.children = children;
		Node leftLeft = new Node(4);
		Node leftRight = new Node(5);
		List<Node> leftChildren = new ArrayList<>();
		leftChildren.add(leftLeft);
		leftChildren.add(leftRight);
		left.children = leftChildren;


		System.out.println(solution.preorder(root));
	}

	static class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	static class Solution {
		public List<Integer> preorder(Node root) {
			List<Integer> result = new ArrayList<>();
			if (root != null) {
				result.add(root.val);
				getChildren(root, result);
			}
			return result;
		}

		private void getChildren(Node root, List<Integer> result) {
			for (Node child : root.children) {
				result.add(child.val);
				if (child.children != null)
					getChildren(child, result);
			}
		}
	}
}