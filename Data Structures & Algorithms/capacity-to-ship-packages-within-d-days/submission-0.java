class Solution {
    public int shipWithinDays(int[] weights, int days) {
        if (weights.length == 0){
            return 0; 
        }

        // Binary search
        int left = 1;
        int right = Arrays.stream(weights).sum(); 
        int res = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (isWithinDays(weights, mid, days)) {
                res = Math.min(res, mid); 
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    public boolean isWithinDays(int[] weights, int weightLimit, int days) {
        int count = 1;
        int currWeight = 0;
        for (int weight : weights) {
            if (weight > weightLimit) {
                return false;
            }

            if (currWeight + weight <= weightLimit) {
                currWeight += weight;
                continue; 
            }

            // Else we will reset 
            count ++;
            currWeight = weight;
        }

        return count <= days;
    }
}