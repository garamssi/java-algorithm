package week2;

/**
 * https://leetcode.com/problems/longest-univalue-path/description/
 * 687. Longest Univalue Path
 *
 */
public class B_LongestUnivaluePath {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    public static void main(String[] args) {
        Integer[] inputList = new Integer[]{5,4,5,4,4,5,3,4,4,null,null,null,4,null,null,4,null,null,4,null,4,4,null,null,4,4};
        TreeNode root = createTree(inputList, 0);
        System.out.println(longestUnivaluePath(root));
    }

    public static TreeNode createTree(Integer[] inputList, int index) {
        if(index >= inputList.length || inputList[index] == null) {
            return null;
        }

        TreeNode treeNode = new TreeNode(inputList[index]);
        treeNode.left = createTree(inputList, 2 * index + 1);
        treeNode.right = createTree(inputList, 2 * index + 2);

        return treeNode;
    }

    public static int longestUnivaluePath(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private static int dfs(TreeNode root, int[] res) {
        if(root == null) {
            return 0;
        }

        int left = dfs(root.left, res);

        if(root.left != null && root.left.val == root.val) {
            left++;
        }

        if(root == null) {
            return 0;
        }

        int right = dfs(root.right, res);

        if(root.right != null && root.right.val == root.val) {
            right++;
        }

        res[0] = Math.max(res[0], left + right);
        return Math.max(left, right);

    }


//    static int result = 0;
//    private static int dfs(TreeNode root) {
//        if (root == null)
//            return 0;
//
//        int left = dfs(root.left);
//        int right = dfs(root.right);
//
//        int val = 0;
//
//        if (root.left != null && root.val == root.left.val)
//            val = Math.max(val, left + 1);
//
//        if (root.right != null && root.val == root.right.val)
//            val = Math.max(val, right + 1);
//
//        if (
//                root.right != null &&
//                        root.left != null &&
//                        root.val == root.right.val &&
//                        root.val == root.left.val
//        )
//            result = Math.max(result, left + right + 2);
//
//        result = Math.max(result, val);
//
//        return val;
//    }
}
