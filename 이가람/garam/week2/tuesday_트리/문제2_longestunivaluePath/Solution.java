package garam.week2.tuesday_트리.문제2_longestunivaluePath;

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

	/**
	 * 동일한 값을 지닌 가장 긴 경로를 찾아라.
 	 *    	 3
 	 * 	  4		3
	 * 	1	1	  3
	 * */
	public static int dfs(TreeNode node) {
		if(node == null) {
			return 0;
		}

		//왼쪽 DFS 시작
		int left = dfs(node.getLeft());

		//오른쪽 DFS 시작
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
