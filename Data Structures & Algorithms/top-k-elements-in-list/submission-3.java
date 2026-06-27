class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Get the count of each character
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 2. Initialize a bucket map (Max will just be num size)
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i ++) {
            buckets[i] = new ArrayList<>();
        }

        // 3. Reverse the map, count as the bucket, and the value as a list of integer
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int count = 0;
        for (int idx = buckets.length - 1; idx > 0; idx --) {
            if (buckets[idx].size() == 0) {
                continue; 
            }

            System.out.println(buckets[idx]);

            for (int num : buckets[idx]) {
                result[count] = num;
                count ++;

                if (count == k) {
                    return result;
                }
            }
        }
        
        return result;
    }
}
