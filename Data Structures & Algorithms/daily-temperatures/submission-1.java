class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Stack where u want to maintain the order 
        // Push the entries into the stack
        // If same / lower temp, continue to push in 
        // If hotter, record down the difference in days 

        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty() || stack.peek()[1] >= temperatures[i]) {
                stack.push(new int[]{i, temperatures[i]});
                continue;
            }

            // Proceed with popping 
            while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int[] temperatureRecording = stack.pop();
                res[temperatureRecording[0]] = i - temperatureRecording[0];
            }

            stack.push(new int[]{i, temperatures[i]});
        }

        while(!stack.isEmpty()) {
            int[] temperatureRecording = stack.pop();
            res[temperatureRecording[0]] = 0;
        }


        return res;
    }
}
