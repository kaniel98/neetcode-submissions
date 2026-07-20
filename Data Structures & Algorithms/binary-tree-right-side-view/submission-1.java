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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i ++) {
                TreeNode node = queue.poll();
                if (i == len - 1) {
                    result.add(node.val); 
                }

                // Else proceed to add it to the queue;
                if (node.left != null) {
                    queue.offer(node.left);
                }  

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }
}
