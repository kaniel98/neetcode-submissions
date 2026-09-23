class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Stack where u want to maintain the order
        // Push the entries into the stack
        // If same / lower temp, continue to push in
        // If hotter, record down the difference in days

        // [day, temperature]
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);
        
        for (int day = 0; day < temperatures.length; day ++) {
            int currentTemp = temperatures[day];
            int[] record = new int[]{day, currentTemp};

            if (stack.isEmpty()) {
                stack.push(record);
                continue; 
            }

            // As long as the top is smaller then the current record
            while (!stack.isEmpty() && stack.peek()[1] < record[1]) {
                int[] prev = stack.pop(); 
                res[prev[0]] = day - prev[0];
            }

            stack.push(record);
        }

        return res;
    }
}
