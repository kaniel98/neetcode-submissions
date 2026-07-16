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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Two pointer, one that is n away, 
        ListNode temp = new ListNode();
        temp.next = head;

        ListNode fast = temp;
        ListNode slow = temp;

        // Move it to be n away; 
        while (n > 0 && fast.next != null) {
            fast = fast.next;
            n --;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next; 
        }

        // At this point we will just connect the before slow and after slow together 
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return temp.next;
    }
}
