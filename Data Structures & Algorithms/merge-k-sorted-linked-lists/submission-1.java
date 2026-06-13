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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)-> a.val - b.val);

        for (ListNode node: lists) {
            queue.offer(node);
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while(!queue.isEmpty()){
            ListNode candidate = queue.poll();
            ListNode next = candidate.next;

            if (next != null) {
                queue.offer(next);
            }

            cur.next = candidate;
            cur = candidate;
        }
        return dummy.next;
    }
}
