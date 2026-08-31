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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int min = Integer.MAX_VALUE;
        int first = -1, last = -1;
        int i = 1;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr.next != null) {
            ListNode next = curr.next;
            if (isCritical(prev, curr, next)) {
                if (first == -1) {
                    first = i;
                } else {
                    min = Math.min(min, i - last);
                }
                last = i;
            }
            prev = curr;
            curr = next;
            i++;
        }
        if (first == last)
            return new int[]{-1, -1};
        return new int[]{min, last - first};
    }
    boolean isCritical(ListNode a, ListNode b, ListNode c) {
        return (b.val > a.val && b.val > c.val) || (b.val < a.val && b.val < c.val);
    }
}