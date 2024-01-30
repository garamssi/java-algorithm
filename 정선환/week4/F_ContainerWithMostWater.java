package week4;

/**
 * https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75
 * 11. Container With Most Water
 */
public class F_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];

            int x = right - left;
            int y = Math.min(leftHeight, rightHeight);

            int area = x * y;
            maxArea = Math.max(maxArea, area);

            if(leftHeight < rightHeight) {
                left++;
            }else {
                right--;
            }
        }

        return maxArea;
    }

}
