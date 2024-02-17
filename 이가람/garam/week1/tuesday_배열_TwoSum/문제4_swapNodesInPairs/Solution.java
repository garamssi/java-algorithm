package garam.week1.tuesday_배열_TwoSum.문제4_swapNodesInPairs;

public class Solution {
	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(4);
		listNode.next.next.next.next = new ListNode(5);
		listNode.next.next.next.next.next = new ListNode(6);

		ListNode result = swapPairs(listNode);
		System.out.println("###################");

	}

	public static ListNode swapPairs(ListNode head){

		ListNode tempNode = head;

		while(tempNode != null && tempNode.next != null ) {
			int value1 = tempNode.val;
			int value2 = tempNode.next.val;
			tempNode.next.val = value1;
			tempNode.val = value2;
			tempNode = tempNode.next.next;
		}

		return head;

	}
}

