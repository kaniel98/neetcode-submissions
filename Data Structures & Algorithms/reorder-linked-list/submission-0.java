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
        // Use fast and slow points to find the middle of the linked list 
        // Get second half
        ListNode fast = head;
        ListNode slow = head; 
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        ListNode second = reverseList(slow.next);
        slow.next = null; // Break the list into two halves
        ListNode first = head;

        while (second != null) {
            ListNode tempOne = first.next;
            ListNode tempTwo = second.next; 
            
            first.next = second;
            second.next = tempOne;

            first = tempOne;
            second = tempTwo;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr; 
            curr = temp; 
        }

        return prev;
    }
}
