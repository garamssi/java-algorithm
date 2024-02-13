package garam.week6.thursday.문제2_PathSum_III;

public class Solution {
    static int counter = 0;

    public static void main(String[] args) {
//        10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        pathSum(root, 8);

    }

    public static int pathSum(TreeNode root, int sum) {

        if (root == null) return 0;

        pathSumHelper(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        return counter;

    }

    static void pathSumHelper(TreeNode root, int sum, int currentSum) {
        if (root == null) {
            return;
        }

        currentSum += root.val;

        if (currentSum == sum) {
            counter++;
        }

        pathSumHelper(root.left, sum, currentSum);
        pathSumHelper(root.right, sum, currentSum);
    }
}
