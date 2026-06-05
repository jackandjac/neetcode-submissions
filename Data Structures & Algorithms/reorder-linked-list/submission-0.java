/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode lh = head;
        ListNode mh = reverse(slow);

        while(mh.next != null) {
            ListNode mn = mh.next;
            ListNode ln = lh.next;
            lh.next = mh;
            mh.next = ln;

            lh = ln;
            mh = mn;
        }


    }

    private ListNode reverse(ListNode node ) {
        ListNode prev = null;

        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}
