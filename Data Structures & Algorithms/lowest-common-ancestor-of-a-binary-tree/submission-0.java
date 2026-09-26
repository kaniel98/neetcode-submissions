/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Different from bsearch tree problem
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // At each point, goal is to check if you are either p or q
        if (root == p || root == q) {
            return root;
        }

        // But if you aren't, check if the bottom is either p or q
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);

        if (left != null && right != null) {
            return root; // Return the current root;
        }

        if (left != null) {
            return left;
        }

        return right;   
    }
}