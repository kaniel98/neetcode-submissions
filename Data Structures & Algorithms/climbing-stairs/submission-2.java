class Solution {

    int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return checkSteps(n, 0);
    }

    private int checkSteps(int target, int curr) {
        if (target == curr) {
            return 1;
        }

        if (target < curr) {
            return 0;
        }

        if (memo[curr] != -1) {
            return memo[curr]; 
        }

        int count = 0; 
        for (int i = 1; i <= 2; i ++) {
            count += checkSteps(target, curr + i);
        }

        return memo[curr] = count;
    }

}