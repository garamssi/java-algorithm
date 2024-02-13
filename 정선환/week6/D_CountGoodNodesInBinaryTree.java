package week6;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * 1448. Count Good Nodes in Binary Tree
 */
public class D_CountGoodNodesInBinaryTree {
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
        Integer[] rootArr = {2,null,4,10,8,null,null,4};

        TreeNode treeNode = createTreeNode(rootArr, 0);
        System.out.println(goodNodes(treeNode));
    }

    private static TreeNode createTreeNode(Integer[] rootArr, int i) {
        if(rootArr.length <= i || rootArr[i] == null) {
            return null;
        }

        TreeNode treeNode = new TreeNode(rootArr[i]);
        treeNode.left = createTreeNode(rootArr, 2 * i + 1);
        treeNode.right = createTreeNode(rootArr, 2 * i + 2);

        return treeNode;
    }

    public static int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }

    static int count = 0;
    private static void dfs(TreeNode root, int rootVal) {
        if(root == null) {
            return ;
        }

        int currRootVal = root.val;
        if(rootVal <= currRootVal) {
            count++;
        }

        dfs(root.left, rootVal);
        dfs(root.right, rootVal);
    }
}
