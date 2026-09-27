class Solution {
    public int brightestPosition(int[][] lights) {
        TreeMap<Integer, Integer> street = new TreeMap<>();

        for (int[] light : lights) {
            // Add the start to the end
            int start = light[0] - light[1];
            int end = light[0] + light[1]; 

            street.put(start, street.getOrDefault(start, 0) + 1);
            street.put(end + 1, street.getOrDefault(end + 1, 0) - 1);
        }

        // From there we iterate to find the first brightest spot
        int max = -1;
        int res = 0;
        int currentBrightness = 0;
        for (int i : street.keySet()) {
            currentBrightness += street.get(i);
            if (currentBrightness > max) {
                res = i; 
                max = currentBrightness;
            }
        }

        return res;
    }
}