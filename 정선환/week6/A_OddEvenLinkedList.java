package week6;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/odd-even-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 * 328. Odd Even Linked List
 */
public class A_OddEvenLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        ListNode head = new ListNode();

        ListNode currNode = head;
        for (int i = 0; i < nums.length; i++) {
            currNode.val = nums[i];
            if(currNode.next == null && i < nums.length - 1) {
                currNode.next = new ListNode();
                currNode = currNode.next;
            }
        }

        oddEvenList(head);
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }

        List<Integer> tempList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();

        int index = 1;
        ListNode currNode = head;
        while(currNode != null) {
            // 짝수 순번
            if(index % 2 == 0) {
                evenList.add(currNode.val);
            // 홀수 순번
            }else {
                tempList.add(currNode.val);
            }
            currNode = currNode.next;
            index++;
        }

        tempList.addAll(evenList);

        ListNode newHead = new ListNode(tempList.get(0));
        ListNode newCurrNode = newHead;
        for (int i = 1; i < tempList.size(); i++) {
            newCurrNode.next = new ListNode(tempList.get(i));
            newCurrNode = newCurrNode.next;
        }

        return newHead;
    }
}
