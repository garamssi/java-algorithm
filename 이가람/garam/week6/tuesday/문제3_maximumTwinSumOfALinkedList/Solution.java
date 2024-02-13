package garam.week6.tuesday.문제3_maximumTwinSumOfALinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 * 주어진 문제는 짝수 길이의 연결 리스트에서 "쌍" 노드의 개념을 사용하여 "최대 쌍 합"을 찾는 것입니다.
 * 연결 리스트의 "쌍"이라는 것은 리스트의 i번째 노드와 (n-1-i)번째 노드가 서로 쌍을 이룬다는 것을 의미합니다.
 * 여기서 n은 연결 리스트의 길이이고, i는 0부터 시작하는 인덱스입니다. 이 때, n은 짝수입니다.
 *
 * 예를 들어, 연결 리스트의 길이가 4인 경우 (n=4), 0번 노드와 3번 노드가 쌍을 이루고, 1번 노드와 2번 노드가 쌍을 이룹니다.
 * 각 쌍의 합을 구한 후, 이 중 최대 값을 찾는 것이 문제의 목표입니다.
 *
 * 예제에서는 연결 리스트가 [5,4,2,1]로 주어졌습니다. 여기서 0번 노드(값 5)와 3번 노드(값 1)가 쌍을 이루고,
 * 그 합은 6입니다. 마찬가지로 1번 노드(값 4)와 2번 노드(값 2)도 쌍을 이루고, 그 합 또한 6입니다.
 * 이 연결 리스트에서 다른 쌍은 존재하지 않으므로, 최대 쌍 합은 6이 됩니다.
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static int pairSum(ListNode head) {

        ListNode currentNode = head;
        List<Integer> list = new ArrayList<>();

        while(currentNode != null) {
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }

        int result = 0;

        for(int i=0; i<list.size(); i++) {
            int pair = list.size() - 1 - i;
            int num = list.get(i) + list.get(pair);
            result = Math.max(num, result);
        }

        return result;
    }

}
