class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
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

        arr.removeLast();
        iterate(idx + 1, nums, arr);
    }
}