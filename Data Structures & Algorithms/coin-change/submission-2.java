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

        int count = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i --) {
            if (amount - coins[i] >= 0) {
                count = Math.min(count, getChange(coins, amount - coins[i]));
            } 
        }

        if (count == Integer.MAX_VALUE) {
            memo.put(amount, count); 
        } else {
            memo.put(amount, count + 1); 
        }

        return memo.get(amount);
    }
}
