class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length; 
        }

        // Put all into hashset 
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 1;
        for (int num : nums) {
            if (set.contains(num -1)) {
                continue; 
            }

            if (!set.contains(num + 1)) {
                continue;
            }

            int curr = 1;
            while (set.contains(num + 1)) {
                curr ++;
                num ++;
            } 

            res = Math.max(res, curr); 
        }

        return res;
    }
}
