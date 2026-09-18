class Solution {

    int[] maxMoneyRobbed;

    public int rob(int[] nums) {
        maxMoneyRobbed = new int[nums.length];
        Arrays.fill(maxMoneyRobbed, -1); 

        return getMaxMoney(nums, 0);
    }

    public int getMaxMoney(int[] houses, int position) {
        if (position >= houses.length) {
            return 0; // Reached the end
        }

        if (maxMoneyRobbed[position] > -1) {
            return maxMoneyRobbed[position];
        }

        // If you rob current, you can't rob the next 
        // Choose if we want rob now or next; 
        int currHouseRobbed = houses[position] + getMaxMoney(houses, position + 2);
        int nextHouseRobbed = getMaxMoney(houses, position + 1);

        return maxMoneyRobbed[position] = Math.max(currHouseRobbed, nextHouseRobbed);
    }
}
