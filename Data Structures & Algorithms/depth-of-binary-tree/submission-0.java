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
    public int maxDepth(TreeNode root) {
        // DFS - Iteratively via stack + preorder (root, left, right)
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        if (root == null) {
            return 0;
        }

        stack.push(new Pair<>(root, 1));
        int res = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> currPair = stack.pop();

            res = Math.max(currPair.getValue(), res);

            TreeNode node = currPair.getKey();
            int depth = currPair.getValue();
            if (node.left != null) {
                stack.push(new Pair<>(node.left, depth + 1));
            }
            if (node.right != null) {
                stack.push(new Pair<>(node.right, depth + 1));
            }
        }

        return res;
    }
}
