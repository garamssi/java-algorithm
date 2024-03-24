class Solution {
    private int count = 0;
    
    public int solution(int[] numbers, int target) {
        solve(0, 0, numbers, target);
        return count;
    }
    
    private void solve(int idx, int sum, int[] numbers, int target) {
        if (idx >= numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        
        solve(idx + 1, sum + numbers[idx], numbers, target);
        solve(idx + 1, sum - numbers[idx], numbers, target);
    }
}