class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> temp = new ArrayList<>();
        temp.add(new ArrayList<>()); 
        dfs(nums, 0, temp);
        return result;
    }

    public void dfs(int[] nums, int idx, List<List<Integer>> results) {
        if (idx == nums.length) {
            result = results;
            return; // No need to proceed further
        }

        List<List<Integer>> nextLists = new ArrayList<>(); 
        for (List<Integer> result : results) {
            // Insert the num at every position available
            for (int i = 0; i <= result.size(); i++) {
                result.add(i, nums[idx]);
                nextLists.add(new ArrayList<>(result)); 
                result.remove(i);
            }
        }
        // Proceed with the next 
        dfs(nums, idx + 1, nextLists);
    }
}