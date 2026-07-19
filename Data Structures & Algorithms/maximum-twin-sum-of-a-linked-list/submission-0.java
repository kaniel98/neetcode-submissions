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
    public int pairSum(ListNode head) {
        // Stack to store first half 
        // Two pointer to reach the second half 
        Stack<Integer> stack = new Stack<>();

        ListNode slow = head;
        ListNode fast = head; 
        while (fast != null && fast.next != null) {
            fast = fast.next.next; 
            stack.push(slow.val); 
            slow = slow.next;
        }

        // At this point, just pop from stack and add it to slow until slow reaches the end 
        int res = 0;
        while (slow != null) {
            res = Math.max(res, slow.val + stack.pop());
            slow = slow.next;
        }

        return res;
    }
}