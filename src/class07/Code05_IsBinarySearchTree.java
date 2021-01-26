package class07;

public class Code05_IsBinarySearchTree {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static class Info {
		public boolean isBST;
		public int max;
		public int min;

		public Info(boolean is, int ma, int mi) {
			isBST = is;
			max = ma;
			min = mi;
		}
	}

//	public static Info process(TreeNode x) {
//		if (x == null) {
//			return null;
//		}
//		Info leftInfo = process(x.left);
//		Info rightInfo = process(x.right);
//		int max = x.val;
//		int min = x.val;
//		if (leftInfo != null) {
//			max = Math.max(leftInfo.max, max);
//			min = Math.min(leftInfo.min, min);
//		}
//		if (rightInfo != null) {
//			max = Math.max(rightInfo.max, max);
//			min = Math.min(rightInfo.min, min);
//		}
//		boolean isBST = true;
//		if (leftInfo != null && !leftInfo.isBST) {
//			isBST = false;
//		}
//		if (rightInfo != null && !rightInfo.isBST) {
//			isBST = false;
//		}
//		boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.val);
//		boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > x.val);
//		if (!(leftMaxLessX && rightMinMoreX)) {
//			isBST = false;
//		}
//		return new Info(isBST, max, min);
//	}

	public static Info process(TreeNode x) {
		if (x == null) {
			return null;
		}
		Info leftInfo = process(x.left);
		Info rightInfo = process(x.right);
		int max = x.val;
		int min = x.val;
		if (leftInfo != null) {
			max = Math.max(leftInfo.max, max);
			min = Math.min(leftInfo.min, min);
		}
		if (rightInfo != null) {
			max = Math.max(rightInfo.max, max);
			min = Math.min(rightInfo.min, min);
		}
		boolean isBST = false;
		boolean leftIsBst = leftInfo == null ? true : leftInfo.isBST;
		boolean rightIsBst = rightInfo == null ? true : rightInfo.isBST;
		boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.val);
		boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > x.val);
		if (leftIsBst && rightIsBst && leftMaxLessX && rightMinMoreX) {
			isBST = true;
		}
		return new Info(isBST, max, min);
	}

}
