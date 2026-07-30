class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i ++) {
            maxHeap.add(nums[i]);
        }
        
        // Poll accordingly 
        for (int i = 0; i < k - 1; i ++) {
            maxHeap.poll();
        }

        return maxHeap.poll();
    }
}
