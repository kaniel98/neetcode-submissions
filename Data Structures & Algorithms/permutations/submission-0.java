class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> temp = new ArrayList<>();
        temp.add(new ArrayList<>());
        permuteDfs(nums, temp, 0);
        return result;
    }

    public void permuteDfs(int[] nums, List<List<Integer>> results, int idx) {
        if (idx == nums.length) {
            result = results;
            return;
        }

        // Else we would iterate
        List<List<Integer>> nextTemp = new ArrayList<>();

        for (List<Integer> list : results) {
            // Add at a specific position
            for (int i = 0; i <= list.size(); i ++) {
                list.add(i, nums[idx]);
                nextTemp.add(new ArrayList<>(list));
                list.remove(i);
            }
        }
        permuteDfs(nums, nextTemp, idx + 1);
    }
}