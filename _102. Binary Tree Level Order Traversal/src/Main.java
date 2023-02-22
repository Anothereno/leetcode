import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();

		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode leftLeft = new TreeNode(4);
		TreeNode leftRight = new TreeNode(5);
		root.left = left;
		root.right = right;
		left.left = leftLeft;
		left.right = leftRight;
		System.out.println(solution.levelOrder(root));
	}

	static 	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	static class Solution {
		public List<List<Integer>> levelOrder(TreeNode root) {
			Map<Integer, List<Integer>> levelMap = new HashMap<>();
			if (root != null) {
				List<Integer> list = new ArrayList<>();
				list.add(root.val);
				levelMap.put(1, list);
				traverse(root, levelMap, 2);
			}
			List<List<Integer>> res = new ArrayList<>();
			for (Map.Entry<Integer, List<Integer>> entry : levelMap.entrySet())
				res.add(entry.getValue());
			return res;
		}

		private void traverse(TreeNode node, Map<Integer, List<Integer>> levelMap, int lvl) {
			if (node.left != null) {
				levelMap.putIfAbsent(lvl, new ArrayList<>());
				levelMap.get(lvl).add(node.left.val);
				traverse(node.left, levelMap, lvl + 1);
			}
			if (node.right != null) {
				levelMap.putIfAbsent(lvl, new ArrayList<>());
				levelMap.get(lvl).add(node.right.val);
				traverse(node.right, levelMap, lvl + 1);
			}
		}
	}
}