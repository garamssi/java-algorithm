package garam.week5.sunday_큐_링크드리스트.문제3_deleteTheMiddleNodeOfALinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Delete the Middle Node of a Linked List
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 중간 노드를 삭제하고 리턴하는 문제.
 */
public class Solution {

	public static void main(String[] args) {

		ListNode head = new ListNode();

		ListNode currentNode = head;
		int[] nums = {1, 3, 4, 7, 1, 2, 6};
//		int[] nums = {1, 2, 3, 4};
//		int[] nums = {2, 1};
		for(int i = 0; i < nums.length; i++) {
			currentNode.val = nums[i];
			if(i != nums.length - 1) {
				currentNode.next = new ListNode();
				currentNode = currentNode.next;
			}
		}

		deleteMiddle(head);
	}

	public static ListNode deleteMiddle(ListNode head) {
		if(head == null || head.next == null){
			return null;
		}
		List<ListNode> list = new ArrayList<>();
		ListNode currentNode = head;

		while(currentNode != null) {
			list.add(currentNode);
			currentNode = currentNode.next;
		}

		int middleNum = list.size() / 2;
		int prevNode = middleNum - 1;
		int nextNode = middleNum + 1;

		if(prevNode >= 0 && nextNode < list.size()) {
			list.get(prevNode).next = list.get(nextNode);
		}
		else {
			list.get(prevNode).next = null;
		}

		return head;
	}
}
