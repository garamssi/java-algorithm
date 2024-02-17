package garam.week1.tuesday.문제2_trappingRainWater;

public class Solution {
	public static void main(String[] args) {
		System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
	}

	public static int trap(int[] height) {
		int volume = 0;
		int left = 0;
		int right = height.length - 1;
		int leftMax = height[left];
		int rightMax = height[right];

		while(left < right) {
			leftMax = Math.max(height[left], leftMax);
			rightMax = Math.max(height[right], rightMax);

			if(leftMax <= rightMax) {
				volume += leftMax - height[left];
				left += 1;
			} else {
				volume += rightMax - height[right];
				right -= 1;
			}

		}

		return volume;
	}
}
