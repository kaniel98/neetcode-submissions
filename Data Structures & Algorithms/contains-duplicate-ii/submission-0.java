class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> appeared = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            if (i > k) {
                appeared.remove(nums[i - k - 1]);
            }
            if (appeared.contains(nums[i])) {
                return true;
            }
            appeared.add(nums[i]);
        }

        return false;
    }
}