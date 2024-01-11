class Solution {
    // brute force
    // 시간복잡도: O(n^2)
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // hashMap
    // 시간복잡도: O(n)
    // trade-off: hashMap이라는 자료구조를 사용하여 시간 복잡도는 줄였으나, Map이라는 저장공간을 추가로 사용하였다. 
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i])) {
                return new int[]{i, numsMap.get(target - nums[i])};   
            }
        }
        return null;
    }

    // two pointer
    // 시간복잡도: O(n)
    // 정렬된 데이터에서만 two pointer를 쓸 수 있다.
    public boolean twoSum3(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return true;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}