class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0; 
        int sum = 0;
        int res = 0;
        
        // Add first k 
        for (int i = 0; i < k; i ++) {
            sum += arr[i];
        }
        if (sum / k >= threshold) {
            res ++; 
        }

        for (int right = k; right < arr.length; right ++) {
            // Proceed to remove left and add right
            sum -= arr[left]; 
            sum += arr[right];
            left ++;

            // Check if the current sum is already more
            if (sum / k >= threshold) {
                res ++; 
            }
        }
        return res; 
    }
}