/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// 두 노드 사이의 거리는 두 노드를 연결하는 간선의 수로 표현
class Solution {
    int result = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return result;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);

        if (node.left != null && node.val == node.left.val) {
            left++;
        } else {
            left = 0;
        }

        if (node.right != null && node.val == node.right.val) {
            right++;
        } else {
            right = 0;
        }

        this.result = Math.max(this.result, left + right);
        return Math.max(left, right);
    }
}