class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1; 
        int max = 0;

        while (left < right) {
            int leftHeight = heights[left];
            int rightHeight = heights[right];

            int area = Math.min(leftHeight, rightHeight) * (right - left);
            max = Math.max(max, area); 

            // Ideally we should be moving the side which is smaller, in hopes of getting something higher 
            if (leftHeight < rightHeight) {
                left ++;
            } else {
                right --;
            }
        }

        return max;
    }
}
