class Solution {

    int res = 0;

    public int goodNodes(TreeNode root) {
        checkChild(root, Integer.MIN_VALUE);

        return res;
    }

    // DFS 
    public void checkChild(TreeNode node, int maxVal) {
        if (node == null) {
            return; 
        }
        
        if (node.val >= maxVal) {
            res++;
            maxVal = node.val;
        }

        checkChild(node.left, maxVal);
        checkChild(node.right, maxVal);
    }
}