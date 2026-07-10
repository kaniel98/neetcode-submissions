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
    public TreeNode invertTree(TreeNode root) {
        // BFS Approach 
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return root;
        }
        queue.offer(root);

        while (!queue.isEmpty()) {
            // Iterate for the first n of the queue 
            int currLength = queue.size();
            for (int i = 0; i < currLength; i ++) {
                TreeNode curr = queue.poll();

                TreeNode temp = curr.left; 
                curr.left = curr.right;
                curr.right = temp;

                // Add back into the queue 
                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        } 
        return root;
    }
}
