package week1;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */
public class D_SwapNodesInPairs {

    public class ListNode {
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

    }

    public ListNode swapPairs(ListNode head) {
        if(null == head)
            return null;

        if(null == head.next)
            return head;

        ListNode tempNode = head;
        head = head.next;
        tempNode.next = head.next;
        head.next = tempNode;

        ListNode parentNode = tempNode;
        tempNode = tempNode.next;
        while(null != tempNode && null != tempNode.next){
            ListNode node = tempNode;
            ListNode nextNode = tempNode.next;

            parentNode.next = nextNode;
            node.next = nextNode.next;
            nextNode.next = node;

            parentNode = node;
            tempNode = node.next;
        }

        return head;
    }



}
