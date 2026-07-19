class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        
        int res = 0;
        int sum = 0;
        prefixCount.put(0, 1); // Accounts for situation where it is directly 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i]; 
            // Atp, we just need to check if the map contains prefix that contains exactly what is needed 
            res += prefixCount.getOrDefault(sum - k, 0);

            // Add to the hashmap first
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}