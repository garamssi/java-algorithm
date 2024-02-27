package week8;

/**
 * https://leetcode.com/problems/find-peak-element/description/?envType=study-plan-v2&envId=leetcode-75
 * 162. Find Peak Element
 */
public class I_FindPeakElement {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
        int[] nums = {1,2,1,3,5,6,4};
//        int[] nums = {1}; // 0
//        int[] nums = {1, 2}; // 1
        System.out.println(findPeakElement(nums));
    }

    // 완전 탐색(Pass)
    public static int findPeakElement(int[] nums) {
        int length = nums.length;
        if(length <= 1) {
            return 0;
        }

        int peak = 0;
        for(int i = 0; i < length; i++) {
            if(i == 0) {
                if(nums[i] > nums[i + 1]) {
                    peak = i;
                }

            }else if(i == length - 1) {
                if(nums[i] > nums[i - 1]) {
                    peak = i;
                }

            }else if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peak = i;
            }

        }
        return peak;
    }
}
