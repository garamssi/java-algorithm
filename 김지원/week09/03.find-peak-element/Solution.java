public class Solution {
    public int findPeakElement(int[] nums) {
        // 예외 처리
        if (nums.length == 1) {
            return 0;
        }
        if (nums[nums.length - 2] < nums[nums.length - 1]) {
            return nums.length - 1;
        }
        
        int left = 0, right = nums.length - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}