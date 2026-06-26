class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : nums) {
            int curr = 1;
            if (set.contains(num - 1)) {
                continue;
            }

            while (set.contains(num + 1)) {
                curr ++;
                num ++;
            }

            res = Math.max(curr, res);
        }
        return res;
    }
}
