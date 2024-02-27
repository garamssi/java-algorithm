package garam.week8.sunday_BinarySearch.문제3_FindPeakElement;

import java.util.*;
public class Solution {

	public static void main(String[] args) {
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
		int start = 1;
		int end = n-2;

		// 시작 인덱스가 종료 인덱스보다 작거나 같을 때까지 반복합니다.
		while(start <= end) {
			// 중간점을 찾습니다.
			int mid = start + (end - start) / 2;
			// 중간점이 피크 조건을 만족하면, 그 인덱스를 반환합니다.
			if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
				return mid;
			}
			// 중간점의 값이 왼쪽 이웃보다 작으면, 피크는 왼쪽에 있습니다.
			else if(nums[mid] < nums[mid-1]){
				end = mid - 1;
			}
			// 중간점의 값이 오른쪽 이웃보다 작으면, 피크는 오른쪽에 있습니다.
			else if(nums[mid] < nums[mid+1]){
				start = mid + 1;
			}
		}
		// 이진 탐색 알고리즘은 항상 피크를 찾으므로 이 라인은 실행되지 않습니다.
		return -1;
	}

}
