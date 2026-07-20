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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp = root;
        TreeNode newNode = new TreeNode(val);

        if (temp == null) {
            return newNode;
        }

        while (temp != null) {
            if (temp.val > val) { // Set to left
                if (temp.left == null) {
                    temp.left = newNode; 
                    break;
                } 
                temp = temp.left; // Iterate down left
            }

            if (temp.val < val) { // set to right 
                if (temp.right == null) {
                    temp.right = newNode;
                    break;
                }
                temp = temp.right; 
            }
        }

        return root; 
    }
}