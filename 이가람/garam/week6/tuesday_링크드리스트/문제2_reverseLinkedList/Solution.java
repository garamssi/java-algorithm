package garam.week6.tuesday_링크드리스트.문제2_reverseLinkedList;

/**
 * https://leetcode.com/problems/reverse-linked-list/solutions/2682085/java-0ms-100-easy-understanding/?envType=study-plan-v2&envId=leetcode-75
 *
 * LinkedList를 역순으로 만들기.
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode();

        ListNode currentNode = head;
        int[] nums = {1,2,3,4,5};

        for(int i = 0; i < nums.length; i++) {
            currentNode.val = nums[i];
            if(i != nums.length - 1) {
                currentNode.next = new ListNode();
                currentNode = currentNode.next;
            }
        }

        reverseList(head);

    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;


        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
