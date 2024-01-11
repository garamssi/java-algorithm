// https://leetcode.com/problems/swap-nodes-in-pairs

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// 시간복잡도: O(n)
// 짝수번째 노드일때, 앞 노드와 값 변경.
class Solution {
    public ListNode swapPairs(ListNode head) {
        int i = 0;
        ListNode cur = head;

        if (cur == null) {
            return null;
        }

        while (cur.next != null) {
            if (i % 2 == 1) {
                cur = cur.next;
                i++;
                continue;
            }
            
            int temp = cur.next.val;
            cur.next.val = cur.val;
            cur.val = temp;
            cur = cur.next;
            i++;
        }

        return head;
    }
}