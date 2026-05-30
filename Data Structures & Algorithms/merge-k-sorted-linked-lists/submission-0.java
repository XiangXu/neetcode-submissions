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
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        
        for(ListNode list : lists) {
            while(list != null) {
                priorityQueue.offer(list.val);
                list = list.next;
            }
        }
        
        while(!priorityQueue.isEmpty()) {
            ListNode node = new ListNode(priorityQueue.poll());
            curr.next = node;
            curr = curr.next;
        }
        
        return dummyHead.next;
    }
}
