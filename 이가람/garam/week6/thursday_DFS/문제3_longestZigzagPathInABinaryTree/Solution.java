package garam.week6.thursday_DFS.문제3_longestZigzagPathInABinaryTree;

/**
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 지그재그로 연속적으로 몇번을 갔는지 카운트하여 리턴.
 *
 */
public class Solution {
    public static int maxLength=0;
    public static void main(String[] args) {
//        1,null,1,1,1,null,null,1,1,null,1,null,null,null,1
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right.right = new TreeNode(1);

        longestZigZag(root);

    }

    public static int longestZigZag(TreeNode root) {
        solve(root,0,0);
        solve(root,1,0);
        return maxLength;
    }

    public static void solve(TreeNode root,int dir,int currLength){
        // 갈 곳이 없다면 아무것도 해주지 않는다.
        if(root==null) return;

        // solve를 호출할 때 지그재그 시에 +1씩 해주기 때문에 max 값을 넣어준다.
        maxLength = Math.max(maxLength,currLength);

        // 지그재그로 타기위한 방향전환,
        if(dir==1){ // 왼쪽
            solve(root.left,0,currLength+1);
            solve(root.right,1,1);
        }
        else{ // 오른쪽
            solve(root.right,1,currLength+1);
            solve(root.left,0,1);
        }
    }

}
