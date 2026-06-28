class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int res = right;

        while (left <= right) {
            
            int speed = (left + right) / 2; 
            
            if (canFinish(piles, speed, h)) {
                res = Math.min(res, speed);
                // Means we can reduce speed 
                right = speed - 1;
            } else {
                left = speed + 1;
            }
        }

        return res;
    }

    private boolean canFinish(int[] piles, int speed, int limit) {
        long totalTimeTaken = 0L;

        for (int pile : piles) {
            totalTimeTaken += Math.ceil((double) pile / speed); 
            if (totalTimeTaken > limit) {
                return false;
            }
        }

        return totalTimeTaken <= limit;
    }
}
