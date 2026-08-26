class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Same implementation as subset 1, just don't redo the same input
        Arrays.sort(nums);
        List<Integer> arr = new ArrayList<>();
        iterate(0, nums, arr);
        return result;
    }

    private void iterate(int idx, int[] nums, List<Integer> arr) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(arr));
            return;
        }
        
        arr.add(nums[idx]);
        iterate(idx + 1, nums, arr);

        // Skip if it is the same
        arr.removeLast();

        // Skip current element and all subsequent duplicates to avoid duplicate subsets
        while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        iterate(idx + 1, nums, arr);
        
    }
}
