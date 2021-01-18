package class07;

public class Code03_PathSum {

	// 测试链接：https://leetcode.com/problems/path-sum
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		return process(root, sum);
	}

	public static boolean process(TreeNode root, int rest) {
		if (root.left == null && root.right == null) {
			return root.val == rest;
		}
		boolean ans = root.left != null ? process(root.left, rest - root.val) : false;
		ans |= root.right != null ? process(root.right, rest - root.val) : false;
		return ans;
	}

}
