package class06;

import java.util.HashMap;

//测试链接：https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
public class Code05_ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static TreeNode buildTree1(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length != in.length) {
			return null;
		}
		return f(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	// 有一棵树，先序结果是pre[L1...R1]，中序结果是in[L2...R2]
	// 请建出整棵树返回头节点
	public static TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2) {
		if (L1 > R1) {
			return null;
		}
		TreeNode head = new TreeNode(pre[L1]);
		if (L1 == R1) {
			return head;
		}
		int find = L2;
		while (in[find] != pre[L1]) {
			find++;
		}
		head.left = f(pre, L1 + 1, L1 + find - L2, in, L2, find - 1);
		head.right = f(pre, L1 + find - L2 + 1, R1, in, find + 1, R2);
		return head;
	}

	public static TreeNode buildTree2(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length != in.length) {
			return null;
		}
		HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			valueIndexMap.put(in[i], i);
		}
		return g(pre, 0, pre.length - 1, in, 0, in.length - 1, valueIndexMap);
	}

	// 有一棵树，先序结果是pre[L1...R1]，中序结果是in[L2...R2]
	// 请建出整棵树返回头节点
	public static TreeNode g(int[] pre, int L1, int R1, int[] in, int L2, int R2,
			HashMap<Integer, Integer> valueIndexMap) {
		if (L1 > R1) {
			return null;
		}
		TreeNode head = new TreeNode(pre[L1]);
		if (L1 == R1) {
			return head;
		}
		int find = valueIndexMap.get(pre[L1]);
		head.left = g(pre, L1 + 1, L1 + find - L2, in, L2, find - 1, valueIndexMap);
		head.right = g(pre, L1 + find - L2 + 1, R1, in, find + 1, R2, valueIndexMap);
		return head;
	}

}
