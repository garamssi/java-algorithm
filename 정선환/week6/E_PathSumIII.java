package week6;

/**
 * https://leetcode.com/problems/path-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75
 * 437. Path Sum III
 */
public class E_PathSumIII {
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
        Integer[] inputList = {10,5,-3,3,2,null,11,3,-2,null,1};
        int targetSum = 8;
        TreeNode treeNode = createTree(inputList, 0);

        System.out.println(pathSum(treeNode, targetSum));
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

    public static int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }

        int targetSumSameCount = 0;

        // left 값 루프
        TreeNode tempNode = root;
        while(tempNode != null) {
            targetSumSameCount += dfsLeft(tempNode, targetSum);
            targetSumSameCount += dfsRight(tempNode, targetSum);
        }

        // right 값 루프
//        while(tempNode != null) {
//            targetSumSameCount += dfsRight(tempNode, targetSum);
//            tempNode = tempNode.right;
//        }

        return targetSumSameCount;
    }


    public static int dfsLeft(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }

        int sum = 0;
        int targetSumSameCount = 0;

        sum += dfsLeft(root.left, targetSum);

        if(sum == targetSum) {
            targetSumSameCount ++;
        }

        return targetSumSameCount;
    }

    public static int dfsRight(TreeNode root, int targetSum) {
        TreeNode tempNode = root;
        int sum = 0;
        int targetSumSameCount = 0;

        while(tempNode != null) {
            sum += tempNode.val;
            if(sum == targetSum) {
                targetSumSameCount ++;
            }
            tempNode = tempNode.right;
        }

        return targetSumSameCount;
    }

}
