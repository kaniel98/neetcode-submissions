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

    int res = 0; 

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0; 
        }
        traverse(root, 0);
        return res;
    }

    public int traverse(TreeNode root, int curr) {
        if (root == null) {
            return curr;
        }
        // Inclusive of current
        curr ++; 

        int left = traverse(root.left, 0);
        int right = traverse(root.right, 0); 
        res = Math.max(res, left + right); 
        return Math.max(left, right) + 1;
    }
}
