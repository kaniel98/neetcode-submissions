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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Add from the back 
        ListNode head = new ListNode();
        ListNode temp = head; 
        // Reverse back and return 
        boolean carryForward = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (carryForward) {
                sum ++;
            }

            if (sum >= 10) {
                carryForward = true; 
                sum -= 10;
            } else {
                carryForward = false;
            }

            ListNode node = new ListNode();
            node.val = sum;
            head.next = node;

            // Move pointer forward
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        // Proceed with the rest of either L1 or L2
        ListNode remainder = l1 != null ? l1 : l2; 
        while (remainder != null) {
            int sum = remainder.val;
            if (carryForward) {
                sum ++;
            }

            if (sum >= 10) {
                carryForward = true; 
                sum -= 10;
            } else {
                carryForward = false;
            }

            ListNode node = new ListNode();
            node.val = sum;
            head.next = node;

            // Move pointer forward
            head = head.next;
            remainder = remainder.next;
        }

        if (carryForward) {
            ListNode node = new ListNode();
            node.val = 1;
            head.next = node;
        }

        return temp.next;
    }


    private ListNode reverseList(ListNode head) {
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