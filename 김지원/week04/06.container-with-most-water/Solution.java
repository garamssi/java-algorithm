class Solution {

    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            maxWater = Math.max(maxWater, calStoredWater(height, left, right));
            // 새 경계의 높이가 더 큰 경우에만 컨테이너 너비를 늘리면 영역이 더 커질 수 있다.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

    private int calStoredWater(int[] height, int i, int j) {
        int min = Math.min(height[i], height[j]);
        return min * (j - i);
    }
}