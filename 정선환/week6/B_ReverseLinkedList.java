package week6;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 * 206. Reverse Linked List
 */
public class B_ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        int[] nums = {1,2};

        ListNode head = new ListNode(nums[0]);
        ListNode currNode = head;
        for(int i = 1; i < nums.length; i++) {
            if(currNode != null) {
                currNode.next = new ListNode(nums[i]);
                currNode = currNode.next;
            }
        }

        reverseList(head);
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }

        List<Integer> nodeList = new ArrayList<>();

        ListNode currNode = head;
        while(currNode != null) {
            nodeList.add(currNode.val);
            currNode = currNode.next;
        }

        ListNode newHead = new ListNode();
        ListNode newCurrNode = newHead;
        for (int i = nodeList.size() - 1; i >= 0; i--) {
            newCurrNode.val = nodeList.get(i);
            if(i != 0) {
                newCurrNode.next = new ListNode();
                newCurrNode = newCurrNode.next;
            }
        }

        return newHead;
    }
}
