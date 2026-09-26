class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        Set<Integer> currentSet = new HashSet<>();
        currentSet.add(0);

        for (int num : nums) {
            Set<Integer> nextSet = new HashSet<>();
            for (int result : currentSet) {
                if (result + num == target) {
                    return true; 
                }

                nextSet.add(result + num);
                nextSet.add(result);
            }

            currentSet = nextSet;
        }
        return false;
    }
}
