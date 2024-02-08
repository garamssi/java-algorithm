class Solution {

    public int pairSum(ListNode head) {
        int size = 1;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            cur = cur.next;
            size++;
        }

        int[] sums = new int[size / 2];

        cur = head;
        for (int i = 0; i < size / 2; i++) {
            sums[i] = cur.val;
            cur = cur.next;
        }

        for (int i = size / 2; i < size; i++) {
            sums[size - 1 -i] += cur.val;
            cur = cur.next;
        }

        Arrays.sort(sums);
        return sums[(size / 2) - 1];
    }

}


class Solution2 {
    public int pairSum(ListNode head) {

        //finding middle

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;
        }

        //reversing the node
        ListNode prev=null;
        ListNode curr=slow;

        while(curr!=null){

            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;

        }



        // Checking maximum twin sum
        int max = 0;

        ListNode h1 = head;
        ListNode h2 = prev; // Reversed second half

        while (h1 != null && h2 != null) {
            int twinSum = h1.val + h2.val;
           // max = Math.max(max, twinSum);
            if (twinSum > max) {
                max = twinSum;
            }

            h1 = h1.next;
            h2 = h2.next;
        }

        return max;
        
    }
}