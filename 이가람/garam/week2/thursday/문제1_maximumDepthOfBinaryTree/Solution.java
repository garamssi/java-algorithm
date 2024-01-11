package garam.week2.thursday.문제1_maximumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.setLeft(new TreeNode(9));
		root.setRight(new TreeNode(10));
		root.getRight().setLeft(new TreeNode(15));
		root.getRight().setRight(new TreeNode(7));

		System.out.println(maximumDepthOfBinaryTree(root));
	}

	public static int maximumDepthOfBinaryTree(TreeNode root) {
		if(root == null) {
			return 0;
		}

		int maxDepth = 0;

		Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
		queue.offer(new Pair<>(root, 1));

		while (!queue.isEmpty()) {
			Pair<TreeNode, Integer> pair = queue.poll();
			TreeNode currentNode = pair.getLeft();
			int currentDepth = pair.getRight();

			maxDepth = Math.max(maxDepth, currentDepth);

			if (currentNode.getLeft() != null) {
				queue.offer(new Pair(currentNode.getLeft(), currentDepth + 1));
			}
			if (currentNode.getRight() != null) {
				queue.offer(new Pair(currentNode.getRight(), currentDepth + 1));
			}
		}

		return maxDepth;

	}


}
