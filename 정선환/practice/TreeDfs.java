package practice;

import java.util.ArrayList;
import java.util.List;

public class TreeDfs {

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

        List<TreeNode> result = dfs(root, null);

        for (TreeNode treeNode : result) {
            System.out.print(treeNode.val + ", ");
        }
        
    }

    private static List<TreeNode> dfs(TreeNode root, List<TreeNode> visited) {
        if(root == null) {
            return null;
        }

        if(visited == null || visited.isEmpty()) {
            visited = new ArrayList<>();
        }

        visited.add(root);

        dfs(root.left, visited);
        dfs(root.right, visited);

        return visited;
    }
}
