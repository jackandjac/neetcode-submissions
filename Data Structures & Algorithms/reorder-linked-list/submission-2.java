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

        ListNode midNode = reverse(slow);

        while(midNode.next != null) {
            ListNode midNext = midNode.next;
            ListNode headNext = head.next;
            head.next = midNode;
            midNode.next = headNext;
            head = headNext;
            midNode = midNext;
        }
    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;

        while( node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}
