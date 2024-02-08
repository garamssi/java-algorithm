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

1,2,3,4,5

5,4 => 5 -> 4


3, 5 -> 4 => 5->4->3

2, 5->4->3 

class Solution {

    public ListNode reverseList(ListNode head) {
       if (head == null || head.next == null) {
           return head;
       }

       ListNode newHead = reverseList(head.next);
         ListNode last = head.next;
       last.next = head;
       head.next = null;

       return newHead;
    }
    
}

class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        List<ListNode> nodeList = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            nodeList.add(cur);
            cur = cur.next;
        }

        Collections.reverse(nodeList);

        head = nodeList.get(0);
        cur = head;
        for (int i = 1; i < nodeList.size(); i++) {
            cur.next = nodeList.get(i);
            cur = cur.next;
        }
        cur.next = null;

        return head;
    }
}
