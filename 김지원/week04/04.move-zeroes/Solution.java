class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && nums[zeroIndex] == 0) {
                swap(nums, i, zeroIndex);
            }
            if (nums[zeroIndex] != 0) {
                zeroIndex++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}