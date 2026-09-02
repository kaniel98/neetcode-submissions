class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sort the array 
        Arrays.sort(candidates); 
        combinationSumDfs(candidates, 0, 0, new ArrayList<>(), target);

        return result;
    }

    private void combinationSumDfs(int[] candidates, int position, int curr, List<Integer> currElements, int target) {
        // If we encounter a duplicate, move forward 
        if (curr == target) {
            result.add(new ArrayList<>(currElements));
            return;
        }

        if (position > candidates.length - 1) {
            return; 
        }

        for (int i = position; i < candidates.length; i ++) {
            if (i > position && candidates[i] == candidates[i - 1]) {
                continue; 
            }

            if (curr + candidates[i] <= target) {
                currElements.add(candidates[i]);
                combinationSumDfs(candidates, i + 1, curr + candidates[i], currElements, target);
                currElements.removeLast();
            }
        }
    }
}
