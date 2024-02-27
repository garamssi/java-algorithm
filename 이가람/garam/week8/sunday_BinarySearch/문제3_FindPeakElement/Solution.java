package garam.week8.sunday_BinarySearch.문제3_FindPeakElement;

import java.util.*;

/**
 * https://leetcode.com/problems/find-peak-element/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 0-인덱스 정수 배열이 주어지면 nums 피크 요소를 찾고 해당 인덱스를 반환합니다.
 * 배열에 여러 피크가 포함된 경우 피크 중 하나 에 대한 인덱스를 반환합니다 .
 *
 * 조건 시간복잡도 O(log n).
 *
 * 첫 번째 예시에서 nums = [1,2,3,1]이 주어졌을 때, 3은 이웃한 숫자 2와 1보다 크기 때문에 피크 요소입니다.
 * 3의 인덱스는 2이므로 출력은 2가 됩니다.
 *
 * 두 번째 예시에서 nums = [1,2,1,3,5,6,4]이 주어졌을 때, 2와 6 모두 피크 요소입니다.
 * 2는 인덱스 1에 있고, 6은 인덱스 5에 있습니다. 따라서 인덱스 1 또는 5를 반환할 수 있습니다.
 */
public class Solution {

	public static void main(String[] args) {

//		findPeakElement(new int[]{1,2,3,1});
		findPeakElement(new int[]{1,2,1,3,5,6,4});
	}

	public static int findPeakElement(int[] nums) {
		// 배열에 단 하나의 요소만 있을 경우, 그 요소가 피크이므로 0을 반환합니다.
		if(nums.length == 1) return 0;

		int n = nums.length;

		// 배열의 첫 번째 요소가 두 번째 요소보다 크면, 첫 번째 요소가 피크입니다.
		if(nums[0] > nums[1]) return 0;
		// 배열의 마지막 요소가 마지막에서 두 번째 요소보다 크면, 마지막 요소가 피크입니다.
		if(nums[n-1] > nums[n-2]) return n-1;

		// 나머지 배열에 대해 이진 탐색을 실행합니다.
		int left = 1;
		int right = n-2;

		// 시작 인덱스가 종료 인덱스보다 작거나 같을 때까지 반복합니다.
		while(left <= right) {
			// 중간점을 찾습니다.
			int mid = left + (right - left) / 2;

			// 중간점이 피크 조건을 만족하면, 그 인덱스를 반환합니다.
			if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
				return mid;
			}
			// 중간점의 값이 왼쪽 이웃보다 작으면, 피크는 왼쪽에 있습니다.
			else if(nums[mid] < nums[mid-1]){
				right = mid - 1;
			}
			// 중간점의 값이 오른쪽 이웃보다 작으면, 피크는 오른쪽에 있습니다.
			else if(nums[mid] < nums[mid+1]){
				left = mid + 1;
			}
		}
		// 이진 탐색 알고리즘은 항상 피크를 찾으므로 이 라인은 실행되지 않습니다.
		return -1;
	}

}
