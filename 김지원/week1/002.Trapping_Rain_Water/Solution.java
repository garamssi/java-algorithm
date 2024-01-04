class Solution {

    // 시간 복잡도: O(n)
    // 가장 높은 기둥을 미리 찾는다.
    // 가장 높은 기둥을 기준으로 왼쪽, 오른쪽 최대 높이의 기둥을 업데이트하며 물을 채운다.
    public int trap(int[] height) {    
        int maxHeight = 0;
        int maxIndex = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxIndex = i;
            }
        }

        int answer = 0;
        
        // left
        int leftMaxHeight = 0;
        for (int i = 0; i < maxIndex; i++) {
            leftMaxHeight = Math.max(leftMaxHeight, height[i]);
            answer += leftMaxHeight - height[i];
        }
        
        int rightMaxHeight = 0;
        // right
        for (int i = height.length - 1; i > maxIndex; i--) {
            rightMaxHeight = Math.max(rightMaxHeight, height[i]);
            answer += rightMaxHeight - height[i];
        }

        return answer;
    }

    // two-pointer
    // 시간복잡도: O(n)
    public int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        int water = 0;

        // left == right인 지점이 최대 높이의 기둥
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);


            if (leftMax <= rightMax) {
                water += leftMax - height[left];
                left++;
            } else {
                water += rightMax - height[right];
                right--;
            }
        }

        return water;
    }
}