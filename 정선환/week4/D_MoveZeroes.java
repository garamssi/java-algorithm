package week4;

/**
 * https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75
 * 283. Move Zeroes
 */
public class D_MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {4,2,4,0,0,3,0,5,1,0};
//        int[] nums = {0,1,0,3,12};
        int[] answer = moveZeroes(nums);

        for(int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static int[] moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                left++;
            }
        }
        return nums;
    }
}
