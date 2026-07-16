class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Position bigger + speed slower = will merge 
        // Position larger + speed faster / same = will not merge 

        // Work from a sorted array
        int[][] sortedPositions = new int[position.length][];

        for (int i = 0; i < position.length; i ++) {
            sortedPositions[i] = new int[]{position[i], speed[i]};
        }
        // Sort the array based on position
        Arrays.sort(sortedPositions, (a, b) -> {
            return Integer.compare(b[0], a[0]);
        });

        // Afterwards we will prepare a stack for it 
        Stack<Double> fleet = new Stack<>(); // Contains the time it takes to reach destination
        for (int i = 0; i < sortedPositions.length; i ++) {
            
            int[] currCar = sortedPositions[i];
            Double timeToReach = (double) (target - currCar[0]) / currCar[1];

            if (fleet.isEmpty()) {
                fleet.push(timeToReach); // Remaining distance divided by speed) 
                continue;
            }

            // Else check if the current speed is faster or slower
            // If it is faster, it means these two groups will never meet, thus we can merge it together
            // But if it is slower, it means it will merge together to the slower speed, so no need to add
            if (fleet.peek() < timeToReach ) {
                fleet.push(timeToReach);
            }
        }

        return fleet.size();
    }
}
