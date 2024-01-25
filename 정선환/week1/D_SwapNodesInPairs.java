package week1;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * 24. Swap Nodes in Pairs
 */
public class D_SwapNodesInPairs {

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

        public String toArray() {
            StringBuilder sb = new StringBuilder();

            ListNode currNode = this;
            while(currNode != null) {
                sb.append(currNode.val);
                if(currNode.next != null) {
                    currNode = currNode.next;
                }else {
                    currNode = null;
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};

        ListNode node = new ListNode(input[0]);

        for(int i = 1; i < input.length; i++) {
            ListNode currNode = node;
            while(currNode.next != null) {
                currNode = currNode.next;
            }

            currNode.next = new ListNode(input[i]);
        }

        ListNode listNode = swapPairs(node);
        System.out.println(listNode.toArray());
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode second = head.next;
        ListNode third = second.next;

        second.next = head;
        head.next = swapPairs(third);

        return second;
    }



}
