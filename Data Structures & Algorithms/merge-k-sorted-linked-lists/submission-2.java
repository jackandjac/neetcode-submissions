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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);
        ListNode dummy = new ListNode();

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
            
        }
        ListNode curHead = dummy;
        while(!pq.isEmpty()){
            ListNode cur = pq.poll();
            ListNode next = cur.next;

            curHead.next = cur;
            curHead = cur;
            if (next != null) {
                pq.offer(next);
            }
        }

        return dummy.next;
    }
}
