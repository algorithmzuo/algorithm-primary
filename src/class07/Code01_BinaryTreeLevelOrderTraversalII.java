package class07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// 测试链接：https://leetcode.com/problems/binary-tree-level-order-traversal-ii
public class Code01_BinaryTreeLevelOrderTraversalII {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans = new LinkedList<>();
		if (root == null) {
			return ans;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> curAns = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				TreeNode curNode = queue.poll();
				curAns.add(curNode.val);
				if (curNode.left != null) {
					queue.add(curNode.left);
				}
				if (curNode.right != null) {
					queue.add(curNode.right);
				}
			}
			ans.add(0, curAns);
		}
		return ans;
	}

	public static void main(String[] args) {
		int testTime = 1000;
		long start;
		long end;

		System.out.println("hello!");
//		ArrayList<Integer> arr1 = new ArrayList<>();
//		start = System.currentTimeMillis();
//		for (int i = 0; i < testTime; i++) {
//			arr1.add(0, i);
//		}
//		end = System.currentTimeMillis();
//		System.out.println(end - start);
//
//		LinkedList<Integer> arr2 = new LinkedList<>();
//		start = System.currentTimeMillis();
//		for (int i = 0; i < testTime; i++) {
//			arr2.add(0, i);
//		}
//		end = System.currentTimeMillis();
//		System.out.println(end - start);
//		System.out.println("=====");

		testTime = 10000000;
		Stack<Integer> stack1 = new Stack<>();
		start = System.currentTimeMillis();
		for (int i = 0; i < testTime; i++) {
			stack1.add(i);
		}
		while (!stack1.isEmpty()) {
			stack1.pop();
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);

		int[] stack2 = new int[testTime];
		int index = 0;
		start = System.currentTimeMillis();
		for (int i = 0; i < testTime; i++) {
			stack2[index++] = i;
		}
		while (index != 0) {
			int a = stack2[--index];
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);

//		while (!s.isEmpty()) {
//			System.out.println(s.pollLast());
//		}
//
//		int[] sta = new int[100];
//		int index = 0;
//		sta[index++] = 1;
//		sta[index++] = 2;
//		sta[index++] = 3;
//
//		System.out.println(sta[--index]);
//		System.out.println(sta[--index]);
//		System.out.println(sta[--index]);

	}

}
