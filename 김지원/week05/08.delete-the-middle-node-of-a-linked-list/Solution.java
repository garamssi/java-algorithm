/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        int size = 1;

        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }

        if (size == 1) {
            return null;
        }

        int middle = size / 2;
        cur = head;
        for (int i = 0; i < middle - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return head;
    }
}