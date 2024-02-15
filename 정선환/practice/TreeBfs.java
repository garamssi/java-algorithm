package practice;

import week7.A_BinaryTreeRightSideView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeBfs {

    public static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(char val) {
            this.val = val;
        }

        TreeNode(char val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode('A');
        root.left = new TreeNode('B');
        root.right = new TreeNode('C');
        root.left.left = new TreeNode('D');
        root.left.right = new TreeNode('E');
        root.right.left = new TreeNode('F');
        root.left.left.left = new TreeNode('G');
        root.left.right.right = new TreeNode('H');
        root.right.left.right = new TreeNode('I');

        List<TreeNode> result = bfs(root);

        for (TreeNode treeNode : result) {
            System.out.print(treeNode.val + ", ");
        }
    }

    private static List<TreeNode> bfs(TreeNode root) {
        List<TreeNode> visited = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            visited.add(currNode);

            if(currNode.left != null) {
                queue.offer(currNode.left);
            }

            if(currNode.right != null) {
                queue.offer(currNode.right);
            }
        }

        return visited;
    }
}
