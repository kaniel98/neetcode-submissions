class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array first, solve by two sum, skip the duplicates 
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        int start = 0;

        for (int i = 0; i < nums.length; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates
            }

            int curr = nums[i]; 
            int left = i + 1;
            int right = nums.length - 1; 
            while (left < right) {
                int sum = nums[left] + nums[right] + curr; 
                if (sum == 0) {
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    left ++;
                    right --;

                    // Repeat same process, move the left pointer 
                    while (left < right && nums[left] == nums[left - 1]) {
                        left ++;
                    }
                } 
                else if (sum < 0) {
                    left ++;
                } else {
                    right --; 
                }
            }
        }
        return res; 
    }
}
