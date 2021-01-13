package class06;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code08_AverageOfLevelsInBinaryTree {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static List<Double> averageOfLevels(TreeNode root) {
		List<Double> ans = new LinkedList<>();
		if (root == null) {
			return ans;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			double sum = 0D;
			for (int i = 0; i < size; i++) {
				TreeNode curNode = queue.poll();
				sum += curNode.val;
				if (curNode.left != null) {
					queue.add(curNode.left);
				}
				if (curNode.right != null) {
					queue.add(curNode.right);
				}
			}
			ans.add(sum / size);
		}
		return ans;
	}

}
