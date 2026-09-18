class Solution {

    int[] minCost;

    public int minCostClimbingStairs(int[] cost) {
        minCost = new int[cost.length];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        return Math.min(checkCost(cost, 0), checkCost(cost, 1));
    }

    private int checkCost(int[] cost, int pos) {
        if (pos >= cost.length) {
            return 0; // End point don't cost
        }

        if (minCost[pos] != Integer.MAX_VALUE) {
            return minCost[pos]; // Means we have solve this before;
        }

        int additionalCost = Integer.MAX_VALUE;
        for (int i = 1; i <= 2; i ++) {
            additionalCost = Math.min(additionalCost, checkCost(cost, pos + i));
        }

        return minCost[pos] = additionalCost + cost[pos]; 
    }
}