class Solution {
    public int maxProfit(int[] prices) {
        // Basically a monotonic stack only, 
        // if it is smaller or equal to the start, then no point

        int start = 0;
        int res = 0;

        for (int end = 0; end < prices.length; end ++) {
            int currPrice = prices[end];

            if (prices[start] < prices[end]) {
                res = Math.max(res, prices[end] - prices[start]);
            } else {
                start = end;
            }

        }

        return res;
    }
}
