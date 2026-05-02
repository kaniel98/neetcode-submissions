class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] output = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i ++) {
            int currTemp = temperatures[i];

            if (stack.size() == 0 || stack.peek()[1] > currTemp) {
                // Day and Temp on the day
                stack.push(new int[]{i, currTemp});
                continue; 
            }

            // Else we will proceed to pop and add
            while(!stack.isEmpty() && stack.peek()[1] < currTemp) {
                int[] temperatureForDay = stack.pop();
                output[temperatureForDay[0]] = i - temperatureForDay[0];
            }

            // Then add it back to list 
            stack.add(new int[]{i, currTemp});
        }

        // Pop and set the rest if any


        return output;
    }
}
