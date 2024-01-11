package garam.week2.tuesday.문제2_longestunivaluePath;

public class Solution {

	public static int result = 0;
	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.setLeft(new TreeNode(4));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(1));
		root.getLeft().setRight(new TreeNode(1));
		root.getRight().setRight(new TreeNode(3));

		System.out.println(dfs(root));
	}

	public static int dfs(TreeNode node) {
		if(node == null) {
			return 0;
		}

		int left = dfs(node.getLeft());
		int right = dfs(node.getRight());

		if(node.getLeft() != null && node.getLeft().getVal() == node.getVal()) {
			left += 1;
		} else {
			left = 0;
		}
		if(node.getRight() != null && node.getRight().getVal() == node.getVal()) {
			right += 1;
		} else {
			right =0;
		}

		result = Math.max(result, left + right );

		return Math.max(left, right);


	}


}
