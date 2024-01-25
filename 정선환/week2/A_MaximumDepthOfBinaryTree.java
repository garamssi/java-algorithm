package week2;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 * 104. Maximum Depth of Binary Tree
 */
public class A_MaximumDepthOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        Integer[] inputList = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = createTree(inputList, 0);
        maxDepth(root);
    }

    private static TreeNode createTree(Integer[] inputList, int index) {
        if (index >= inputList.length || inputList[index] == null) {
            return null;
        }

        TreeNode node = new TreeNode(inputList[index]);
        node.left = createTree(inputList, 2 * index + 1);
        node.right = createTree(inputList, 2 * index + 2);

        return node;

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

}
