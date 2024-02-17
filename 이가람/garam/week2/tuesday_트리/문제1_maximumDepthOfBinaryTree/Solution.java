package garam.week2.tuesday_트리.문제1_maximumDepthOfBinaryTree;

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

		// 노드와 깊이 값을 삽일할 수 있도록 큐를 생성한다.
		Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

		// 시작할 값을 큐에 삽입
		queue.offer(new Pair<>(root, 1));

		// 큐가 비어있지 않을 때 실행
		// [{TreeNode, 1}, {TreeNode, 2}, {TreeNode, 3}]
		while (!queue.isEmpty()) {

			// 큐 값에서 하나 꺼내옵니다.
			Pair<TreeNode, Integer> pair = queue.poll();

			// 노드 값을 꺼내오고
			TreeNode currentNode = pair.getLeft();

			// 깊이 값을 꺼내옵니다.
			int currentDepth = pair.getRight();

			/**
			 * maxDepth 초기 값은 0
			 * 큐에 가지고 있는 currentDepth 와 maxDepth 와 비교하여 큰 값으로 maxDepth에 삽입합니다.
			 * */
			maxDepth = Math.max(maxDepth, currentDepth);

			if (currentNode.getLeft() != null) {
				// 왼쪽 노드가 있다면 +1 depth를 지정하여 큐에 넣어 다음 방문을 지정합니다.
				queue.offer(new Pair(currentNode.getLeft(), currentDepth + 1));
			}
			if (currentNode.getRight() != null) {
				// 오른쪽 노드가 있다면 +1 depth를 지정하여 큐에 넣어 다음 방문을 지정합니다.
				queue.offer(new Pair(currentNode.getRight(), currentDepth + 1));
			}
		}

		return maxDepth;

	}


}
