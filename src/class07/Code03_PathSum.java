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

	public static boolean isSum = false;

	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		isSum = false;
		process(root, 0, sum);
		return isSum;
	}

	public static void process(TreeNode x, int preSum, int sum) {
		if (x.left == null && x.right == null) {
			if (x.val + preSum == sum) {
				isSum = true;
			}
			return;
		}
		// x是非叶节点
		preSum += x.val;
		if (x.left != null) {
			process(x.left, preSum, sum);
		}
		if (x.right != null) {
			process(x.right, preSum, sum);
		}
	}

//	public static boolean hasPathSum(TreeNode root, int sum) {
//		if (root == null) {
//			return false;
//		}
//		return process(root, sum);
//	}
//
//	public static boolean process(TreeNode root, int rest) {
//		if (root.left == null && root.right == null) {
//			return root.val == rest;
//		}
//		boolean ans = root.left != null ? process(root.left, rest - root.val) : false;
//		ans |= root.right != null ? process(root.right, rest - root.val) : false;
//		return ans;
//	}

}
