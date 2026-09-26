class Solution {
    
    int[] prefixSums;
    int totalSum;
    Random rand = new Random();

    public Solution(int[] w) {
        prefixSums = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            prefixSums[i] = sum;
        }
        totalSum = sum;
    }

    public int pickIndex() {
        int target = rand.nextInt(totalSum) + 1;

        // Do a binary search to find the random number
        int left = 0;
        int right = prefixSums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}