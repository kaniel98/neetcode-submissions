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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true; 
        }

        return dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    // Check if it is the same at every node;
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true; 
        } else if (p == null || q == null) {
            return false;
        }

        boolean leftCheck = isSameTree(p.left, q.left);
        boolean rightCheck = isSameTree(p.right, q.right);

        return leftCheck && rightCheck && p.val == q.val;
    }
}
