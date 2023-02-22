public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();

		TreeNode root = new TreeNode(2147483647);
//		TreeNode left = new TreeNode(4);
//		TreeNode right = new TreeNode(6);
//		root.left = left;
//		root.right = right;
//		TreeNode leftLeft = new TreeNode(3);
//		TreeNode leftRight = new TreeNode(7);
//		right.left = leftLeft;
//		right.right = leftRight;
		System.out.println(solution.isValidBST(root));
	}

	static public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}

	static class Solution {
		public boolean isValidBST(TreeNode root) {
			return validateNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
		}

		private boolean validateNode(TreeNode node, Long min, Long max) {
			if (node == null)
				return true;

			if (node.left != null && node.left.val == node.val || node.right != null && node.right.val == node.val) return false;

			if (node.val <= min || node.val >= max) return false;
			return validateNode(node.left, min, (long) node.val) && validateNode(node.right, (long) node.val, max);
		}
	}
}