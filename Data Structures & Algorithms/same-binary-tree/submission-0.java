/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfsCheck(p, q);
    }

    // Check if it is the same at every node;
    public boolean dfsCheck(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true; 
        } else if (p == null || q == null) {
            return false;
        }

        boolean leftCheck = dfsCheck(p.left, q.left);
        boolean rightCheck = dfsCheck(p.right, q.right);

        return leftCheck && rightCheck && p.val == q.val;
    }
}
