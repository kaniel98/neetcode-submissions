class Solution {
    int[][] dp;

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2]; 
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(prices, 0, 0);   
    }

    private int dfs(int[] prices, int day, int holding) {
        if (day == prices.length) {
            return 0; 
        }

        if (dp[day][holding] != -1) {
            return dp[day][holding];
        }

        // Option 1: Do nothing on this day
        int res = dfs(prices, day + 1, holding); 
        if (holding == 1) {
            // Option 2: Sell the stock
            res = Math.max(res, prices[day] + dfs(prices, day + 1, 0)); 
        } else {
            // Option 2: Buy the stock
            res = Math.max(res, -prices[day] + dfs(prices, day + 1, 1));
        }

        return dp[day][holding] = res; 
    }
}