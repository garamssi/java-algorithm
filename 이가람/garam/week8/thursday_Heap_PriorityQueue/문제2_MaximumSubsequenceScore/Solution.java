package garam.week8.thursday_Heap_PriorityQueue.문제2_MaximumSubsequenceScore;

import java.util.*;

/**
 * https://leetcode.com/problems/maximum-subsequence-score/?envType=study-plan-v2&envId=leetcode-75
 *
 * 두 개의 0-인덱스 정수 배열 nums1과 nums2가 주어지며, 두 배열은 동일한 길이 n을 가집니다. 또한 양의 정수 k도 주어집니다.
 * 여러분의 목표는 nums1에서 길이가 k인 부분수열(subsequence)을 선택하는 것입니다.
 * 부분수열은 배열에서 일부 혹은 전혀 원소를 삭제하지 않고 얻을 수 있는 인덱스의 수열을 의미합니다.
 *
 * 선택한 인덱스 i0, i1, ..., ik-1에 대해서, 여러분의 '점수(score)'는 다음과 같이 정의됩니다:
 *
 * nums1에서 선택된 원소들의 합에 nums2에서 같은 인덱스에 해당하는 원소들 중 최솟값을 곱한 값입니다.
 * 이 점수는 수식으로 간단히 (nums1[i0] + nums1[i1] + ... + nums1[ik-1]) * min(nums2[i0], nums2[i1], ..., nums2[ik-1])로 표현할 수 있습니다.
 * 이때 가능한 최대 점수를 반환해야 합니다.
 *
 * 예시 1을 통해 설명하겠습니다:
 *
 * nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
 * 가능한 부분수열 점수는 다음과 같습니다:
 * 인덱스 0, 1, 2를 선택했을 때: 점수 = (1+3+3) * min(2,1,3) = 7
 * 인덱스 0, 1, 3를 선택했을 때: 점수 = (1+3+2) * min(2,1,4) = 6
 * 인덱스 0, 2, 3를 선택했을 때: 점수 = (1+3+2) * min(2,3,4) = 12
 * 인덱스 1, 2, 3를 선택했을 때: 점수 = (3+3+2) * min(1,3,4) = 8
 * 따라서 최대 점수는 12입니다.
 */
public class Solution {
    public static void main(String[] args) {
        maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3);
    }

    public static long maxScore(int[] num1, int[] num2, int k) {
        // 배열의 길이를 n에 저장
        int n = num1.length;

        // 각 원소의 num2 값과 해당하는 num1 값의 쌍을 저장하기 위한 2차원 배열을 선언
        int[][] ess = new int[n][2];

        for (int i = 0; i < n; ++i)
            // num2의 원소를 첫 번째 컬럼에, 해당하는 num1의 원소를 두 번째 컬럼에 저장
            ess[i] = new int[] {num2[i], num1[i]};

        // ess 배열을 num2의 값을 기준으로 내림차순 정렬
        Arrays.sort(ess, (a, b) -> b[0] - a[0]);

        // 우선순위 큐를 선언합니다. k 개의 최소 num1 값을 유지하기 위해 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);

        // 최대 점수를 저장할 변수를 선언
        long answer = 0;
        // 선택된 num1 원소들의 합을 저장할 변수
        long num1Sum = 0;

        // ess 배열을 순회
        for (int[] es : ess) {
            // 현재 num1 원소를 우선순위 큐에 추가
            pq.add(es[1]);
            // num1 원소들의 합을 갱신
            num1Sum = (num1Sum + es[1]);

            // 우선순위 큐의 크기가 k보다 크면, 가장 작은 원소를 제거(합에서도 뺌).
            if (pq.size() > k) {
                num1Sum -= pq.poll();
            }
            // 우선순위 큐의 크기가 k라면, 현재의 합과 num2의 최소값을 곱하여 최대 점수를 갱신
            if (pq.size() == k) {
                answer = Math.max(answer, (num1Sum * es[0]));
            }
        }

        return answer;
    }
}
