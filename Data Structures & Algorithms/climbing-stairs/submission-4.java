class Solution {
    public int climbStairs(int n) {
        // Bottom up approach
        // Each step only can be reached by + 1 or + 2 
        if (n <= 2) {
            return n;
        }

        int stepOne = 1; 
        int stepTwo = 2;
        int recentStep = 0; // Placeholder; 

        for (int i = 2; i < n; i ++) {
            recentStep = stepOne + stepTwo; 
            stepOne = stepTwo;
            stepTwo = recentStep;
        }

        return recentStep;
    }
}
