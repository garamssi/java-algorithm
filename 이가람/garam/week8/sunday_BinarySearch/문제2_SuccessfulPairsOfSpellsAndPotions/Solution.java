package garam.week8.sunday_BinarySearch.문제2_SuccessfulPairsOfSpellsAndPotions;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 주문 배열 spells과 물약 배열 potions을 받아 각 주문에 대해 해당 주문과 성공적으로 작동할 물약의 개수를 계산합니다.
 * 여기서 '성공적으로 작동한다'는 주문과 물약의 강도를 곱한 값이 success 값 이상이 되어야 함을 의미
 */
public class Solution {
    public static void main(String[] args) {
        successfulPairs(new int[]{5,1,3}, new int[]{1,2,3,4,5}, 7);

    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {

		// 물약 배열을 오름차순으로 정렬
        Arrays.sort(potions);

        // 모든 주문에 대해 반복
        for (int i = 0; i < spells.length; i++) {

            // 최소 물약 강도 계산
            long target = (success + spells[i] - 1) / spells[i];

            int left = 0; // 이진 탐색을 위한 왼쪽 포인터
            int right = potions.length - 1; // 이진 탐색을 위한 오른쪽 포인터

            // 이진 탐색 실행
            while (left < right) {
                int mid = (right + left) / 2; // 중간점 계산
                // 중간점의 물약 강도가 목표보다 작으면 왼쪽 포인터를 오른쪽으로 옮김
                if (potions[mid] < target) left = mid + 1;
                    // 그렇지 않으면 오른쪽 포인터를 중간점으로 옮김
                else right = mid;
            }

            // 마지막 검사로 왼쪽 포인터 위치의 물약 강도가 목표보다 작으면 포인터를 오른쪽으로 이동 -> 없다는 것
            if (potions[left] < target) left++;

            // 주문 배열의 현재 인덱스를 성공적인 물약의 개수로 업데이트
            spells[i] = potions.length - left;
        }

        // 각 주문에 대한 성공적인 물약의 개수가 담긴 배열 반환
        return spells;

    }

}
