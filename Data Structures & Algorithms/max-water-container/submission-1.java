class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int leftHeight = heights[left];
            int rightHeight = heights[right];

            int curr = Math.min(leftHeight, rightHeight) * (right - left);
            res = Math.max(curr, res); 

            if (leftHeight < rightHeight) {
                left ++; 
            } else {
                right --;
            }
        }

        return res;
    }
}
