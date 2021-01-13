package class06;

import java.util.HashMap;

public class Code06_ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}
		return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
	}

	public static TreeNode process(int[] pre, int L1, int R1, int[] in, int L2, int R2,
			HashMap<Integer, Integer> inMap) {
		if (L1 > R1) {
			return null;
		}
		TreeNode head = new TreeNode(pre[L1]);
		if (L1 == R1) {
			return head;
		}
		int find = inMap.get(pre[L1]);
		head.left = process(pre, L1 + 1, L1 + find - L2, in, L2, find - 1, inMap);
		head.right = process(pre, L1 + find - L2 + 1, R1, in, find + 1, R2, inMap);
		return head;
	}

}
