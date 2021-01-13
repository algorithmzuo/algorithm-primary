package class06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code09_PathSumII {

	// 测试链接：https://leetcode.com/problems/path-sum-ii
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		LinkedList<Integer> path = new LinkedList<>();
		process(root, sum, path, ans);
		return ans;
	}

	public static void process(TreeNode root, int rest, LinkedList<Integer> path, List<List<Integer>> ans) {
		path.addLast(root.val);
		if (root.left == null && root.right == null) {
			if (root.val == rest) {
				ans.add(copy(path));
			}
		} else {
			if (root.left != null) {
				process(root.left, rest - root.val, path, ans);
			}
			if (root.right != null) {
				process(root.right, rest - root.val, path, ans);
			}
		}
		path.pollLast();
	}

	public static List<Integer> copy(LinkedList<Integer> path) {
		List<Integer> ans = new ArrayList<>();
		for (Integer num : path) {
			ans.add(num);
		}
		return ans;
	}

}
