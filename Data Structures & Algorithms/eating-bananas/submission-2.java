class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Min will be 1, max will be the number of bananas in the pile 
        int left = 1;
        int right =  Arrays.stream(piles).max().getAsInt();

        // Have a helper method which evaluates how long it takes to finish the piles given K
        // If true, we can move it down further, else move up K 
        int res = right; 
        while (left <= right) {
            int middle = (left + right) / 2;
            if (canFinish(piles, middle, h)) {
                res = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return res;
    }

    private boolean canFinish(int[] piles, int speed, int limit) {
        long currTime = 0;

        for (int pile : piles) {
            currTime += Math.ceil((double) pile / speed); 
        }

        return currTime <= limit;
    }
}
