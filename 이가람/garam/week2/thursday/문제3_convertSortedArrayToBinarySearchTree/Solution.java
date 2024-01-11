package garam.week2.thursday.문제3_convertSortedArrayToBinarySearchTree;

public class Solution {
	public static void main(String[] args) {
		TreeNode treeNode = sortedArrayToBST(new int[]{-10, -7, -3, 0, 5, 7, 9});
		System.out.println(treeNode);

	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length == 0) {
			return null;
		}
		return construct(nums, 0, nums.length - 1);
	}

	public static TreeNode construct(int[] nums, int lo, int hi) {
		if(lo > hi) {
			return null;
		}
		int mid = lo + (hi - lo) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = construct(nums, lo, mid - 1);
		node.right = construct(nums, mid + 1, hi);

		return node;
	}
}
