package week1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 * 2 <= nums.length <= 10^4
 * -109 <= nums[i] <= 10^9
 * -109 <= target <= 10^9
 * Only one valid answer exists.
 */
class TwoSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input 데이터
        String numsString = sc.nextLine();
        int[] nums = Arrays.stream(numsString.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = sc.nextInt();

        // 알고리즘 호출
        twoSum(nums, target);
    }

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

//    ===========================================================================
//    강의에서 배운대로 접근했는데 안되었음
//    output으로 인덱스를 추출해야하는데 sort를 하면 인덱스가 바뀌어 버림
//    그럼 별도로 기존 인덱스를 기억하는 등.. 추가적인 작업이 들어가야해서 비효율적일 것 같았음
//    ===========================================================================
//    public static int[] twoSum(int[] nums, int target) {
//        Arrays.sort(nums);
//
//        int[] answer = new int[2];
//        int i = 0;
//        int j = nums.length - 1;
//
//        while (i < j) {
//            int numSum = nums[i] + nums[j];
//            if(numSum == target) {
//                answer[0] = i;
//                answer[1] = j;
//                break;
//
//            }else if(numSum > target) {
//                j--;
//
//            }else if(numSum < target) {
//                i++;
//            }
//        }
//
//        return answer;
//    }
}
