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

    TreeNode result; 

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorDfs(root, p, q);
    }

    public TreeNode lowestCommonAncestorDfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        // If the curr is either one, it means it is the LCA 
        if (p.val == root.val || q.val == root.val) {
            return root;
        }


        // The moment it splits, it means the current one is the lowest common
        if ((p.val > root.val && q.val < root.val) || (p.val < root.val && q.val > root.val)) {
            return root;
        }
        
        // If both smaller, means go left
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorDfs(root.left, p, q);
        }

        // If both larger, means go right
         if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorDfs(root.right, p, q);
        }

        return null;
    }
}
