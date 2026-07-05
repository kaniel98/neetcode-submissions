class Solution {
    public int maxProfit(int[] prices) {
        // Basically a monotonic stack only, 
        // if it is smaller or equal to the start, then no point

        int start = 0;
        int res = 0;
        int currHighest = 0; 

        for (int end = 0; end < prices.length; end ++) {
            int currPrice = prices[end];

            if (currPrice <= prices[start]) {
                res = Math.max(res, currHighest - prices[start]);
                currHighest = currPrice;
                start = end;
                continue;
            } 

            currHighest = Math.max(currPrice, currHighest);
        }

        return Math.max(res, currHighest - prices[start]);
    }
}
