package garam.week7.tuesday_BFS.문제1_BinaryTreeRightSideView;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=leetcode-75
 *
 */

public class Solution {
    public static void main(String[] args) {

//        [1,2,3,null,5,null,4]

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        rightSideView(root);

    }

    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == size - 1) list.add(node.val); // 각 레벨에서 가장 오른쪽에 위치한 노드를 의미
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return list;
    }
}
