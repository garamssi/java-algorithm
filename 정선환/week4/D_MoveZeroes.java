package week4;

/**
 * https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75
 * 283. Move Zeroes
 */
public class D_MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        int length = nums.length;

        for(int i = 0; i < length; i++) {
            if(nums[i] != 0) {
                nums[zeroIndex] = nums[i];
                zeroIndex++;
            }
        }

        for(; zeroIndex < length; zeroIndex++) {
            nums[zeroIndex] = 0;
        }
    }
}
