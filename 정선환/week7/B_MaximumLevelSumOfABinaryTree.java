package week7;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * 1161. Maximum Level Sum of a Binary Tree
 */
public class B_MaximumLevelSumOfABinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

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
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(7);
//        root.right = new TreeNode(0);
//        root.left.left = new TreeNode(7);
//        root.left.right = new TreeNode(-8);

        TreeNode root = new TreeNode(-100);
        root.left = new TreeNode(-200);
        root.right = new TreeNode(-300);
        root.left.left = new TreeNode(-20);
        root.left.right = new TreeNode(-5);
        root.right.left = new TreeNode(-10);

        System.out.println(maxLevelSum(root));
    }

    public static int maxLevelSum(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        int maxLevel = 0;
        int maxLevelSum = Integer.MIN_VALUE;

        int currlevel = 1;
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            int valSum = 0;
            for(int i = 0; i < queueSize; i++) {
                TreeNode currNode = queue.poll();

                valSum += currNode.val;

                if(currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if(currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }

            if(valSum > maxLevelSum) {
                maxLevelSum = valSum;
                maxLevel = currlevel;
            }

            currlevel++;
        }

        return maxLevel;
    }
}
