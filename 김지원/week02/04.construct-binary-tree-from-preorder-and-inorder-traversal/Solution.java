/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // 1. 전위 순회, 중위 순회 모두 root를 기준으로 왼쪽 노드를 모두 순회한 후 오른쪽 노드를 순회한다.
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode dfs(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preIndex > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        // 전위 순회 값이 중위 순회에서는 몇 번째 인덱스인지 추출
        int inIndex = 0;
        for (int i = 0; i <= inEnd; i++) {
            if (inorder[i] == preorder[preIndex]) {
                inIndex = i;
            }
        }

        TreeNode node = new TreeNode(inorder[inIndex]);
        preIndex++;

        node.left = dfs(preIndex, inStart, inIndex - 1, preorder, inorder);
        node.right = dfs(preIndex + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);

        return node;
    }
}