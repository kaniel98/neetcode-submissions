class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // bucket sort approach
        // Initialize the buckets
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i ++) {
            buckets[i] = new ArrayList<>();
        }

        // Add the count into the bucket 
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] output = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i > 0; i --) {
            List<Integer> eligibleNums = buckets[i];
            if (eligibleNums.size() == 0) {
                continue; 
            }

            // Else add it to the output
            for (Integer eligibleNum : eligibleNums) {
                if (index == k) {
                    return output;
                }
                output[index] = eligibleNum;
                index ++;
            }
        }
        return output;
    }
}
