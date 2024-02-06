package week5;

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 * 2095. Delete the Middle Node of a Linked List
 */
public class I_DeleteTheMiddleNodeOfALinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static void main(String[] args) {
//        int[] nodeArr = {1,3,4,7,1,2,6};
        int[] nodeArr = {1};

        ListNode head = new ListNode(nodeArr[0]);
        System.out.println(head);
        for (int i = 1; i < nodeArr.length; i++) {
            ListNode currNode = head;
            System.out.println(currNode);
            while(currNode.next != null) {
                currNode = currNode.next;
            }

            currNode.next = new ListNode(nodeArr[i]);
        }

        ListNode listNode = deleteMiddle(head);
        System.out.println(listNode);
    }

    public static ListNode deleteMiddle(ListNode head) {
        int size = 0;
        ListNode currListNode = head;
        while(currListNode != null) {
            currListNode = currListNode.next;
            size++;
        }

        if(size == 1) {
            return null;
        }

        int deleteIndex = size / 2;

        currListNode = head;
        for(int i = 0; i < deleteIndex - 1; i++) {
            currListNode = currListNode.next;
        }

        currListNode.next = currListNode.next.next;

        return head;
    }
}

