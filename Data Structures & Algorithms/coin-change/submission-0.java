class Solution {

    Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        Integer result = getChange(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int getChange(int[] coins, int amount) {
        if (memo.containsKey(amount)) {
            return memo.get(amount); 
        }

        if (amount == 0) {
            return 0; 
        }

        // We want to find the minimum it takes
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                // We will try for every coin that is not negative
                int result = getChange(coins, amount - coin);
                if (result == Integer.MAX_VALUE) {
                    continue;
                }
                res = Math.min(res, 1 + result);
            }
        }

        // Afterwards put into the map 
        memo.put(amount, res);

        return res;
    }
}
