package garam.week6.tuesday_링크드리스트.문제1_oddEvenLinkedList;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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

        oddEvenList(head);

    }

    public static ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        Deque<Integer> odd = new ArrayDeque<>();
        Deque<Integer> even = new ArrayDeque<>();
        ListNode curNode = head;

        int index = 1;

        while(curNode != null){

            if(index % 2 == 0) {
                even.offer(curNode.val);
            } else {
                odd.offer(curNode.val);
            }

            curNode = curNode.next;
            index++;
        }

        ListNode result = new ListNode();
        curNode = result;

        while (curNode != null){
            if(!odd.isEmpty()){
                curNode.val = odd.pollFirst();
            } else if(!even.isEmpty()) {
                curNode.val = even.pollFirst();
            }

            if( odd.isEmpty() && even.isEmpty() ) {
                break;
            }

            curNode.next = new ListNode();
            curNode = curNode.next;
        }

        return result;


//        if(head==null) return head;
//
//        ListNode odd = head;
//        ListNode even = head.next;
//        ListNode evenHead = even;
//
//        while(even!=null && even.next!=null){
//            odd.next = odd.next.next;
//            even.next = even.next.next;
//            odd = odd.next;
//            even = even.next;
//        }
//
//        odd.next = evenHead;
//
//        return head;
    }
}
