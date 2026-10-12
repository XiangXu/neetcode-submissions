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
        if (lists == null || lists.length == 0) return null;
        return divide(lists, 0, lists.length - 1);
    }

    // 相当于 mergeSortHelper：拆成两半，各自合并，再合并两个结果
    private ListNode divide(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];          // 只剩一个链表，直接返回
        int m = l + (r - l) / 2;
        ListNode left = divide(lists, l, m);
        ListNode right = divide(lists, m + 1, r);
        return mergeTwo(left, right);
    }

     private ListNode mergeTwo(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);     // 哑结点，省去处理头结点的麻烦
        ListNode tail = dummy;                // 相当于 k：下一个结点接在哪里
        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;      // 剩下的一整段直接接上
        return dummy.next;
    }
}
