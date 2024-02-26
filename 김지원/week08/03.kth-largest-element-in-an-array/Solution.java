class Solution {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            q.offer(nums[i]);
        }

        int answer = 0;
        for (int i = 0; i < k; i++) {
            answer = q.poll();
        }

        return answer;
    }
}