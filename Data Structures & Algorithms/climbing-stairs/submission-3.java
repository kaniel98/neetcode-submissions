class Solution {
    public int climbStairs(int n) {
        // Bottom up approach
        // Each step only can be reached by + 1 or + 2 
        int[] steps = new int[n];
        if (n <= 2) {
            return n;
        }

        steps[0] = 1; 
        steps[1] = 2;
        for (int i = 2; i < n; i ++) {
            steps[i] = steps[i - 1] + steps[i -2];
        }

        return steps[n - 1];
    }
}
