class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        combinationSumDfs(nums, target, 0, new ArrayList<>(), 0);
        return result;
    }


    private void combinationSumDfs(int[] nums, int target, int curr, List<Integer> currElements, int position) {
        if (position > nums.length - 1) {
            return; // No need to continue with this case
        }

        if (target == curr) {
            result.add(new ArrayList<>(currElements));
            return;
        }

        // Iterate for each
        for (int i = position; i < nums.length; i ++) {
            if (curr + nums[i] > target) {
                continue; // No need to continue with this case
            }
            currElements.add(nums[i]);
            combinationSumDfs(nums, target, curr + nums[i], currElements, i);
            currElements.removeLast();
        }
    }
}
