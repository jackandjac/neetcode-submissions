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

        ListNode midHead = reverse(slow);
        ListNode home = head;

        while (midHead.next != null) {
            ListNode mnext = midHead.next;
            ListNode hnext = head.next;

            head.next = midHead;
            midHead.next = hnext;

            head = hnext;
            midHead = mnext;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;

        while (node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}
