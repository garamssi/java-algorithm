package week7.tuesday_BFS.문제2_MaximumLevelSumOfBinaryTree;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
//		[1,7,0,7,-8,null,null]
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(7);
		root.right =new TreeNode(0);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(-8);

		System.out.println(maxLevelSum(root));

	}

	public static int maxLevelSum(TreeNode root) {

		Deque<Map.Entry<TreeNode, Integer>> deque = new ArrayDeque<>();
		deque.add(new AbstractMap.SimpleEntry<>(root, 1));

		Map<Integer, Integer> resultMap = new HashMap<>();


		while(!deque.isEmpty()){

			// 꺼냄
			Map.Entry<TreeNode, Integer> targetMap = deque.pollLast();
			TreeNode targetNode = targetMap.getKey();
			int level = targetMap.getValue();

			// key 는 레벨, 값은 레벨 별로 val 을 sum
			resultMap.merge(level, targetNode.val, Integer::sum);

			// 왼쪽
			if (targetNode.left != null ) {
				deque.offer(new AbstractMap.SimpleEntry<>(targetNode.left, level+1));
			}
			// 오른쪽
			if (targetNode.right != null) {
				deque.offer(new AbstractMap.SimpleEntry<>(targetNode.right, level+1));
			}

		}

		Map.Entry<Integer, Integer> maxEntry = Collections.max(resultMap.entrySet(), Map.Entry.comparingByValue());

		return maxEntry.getKey();
	}
}
