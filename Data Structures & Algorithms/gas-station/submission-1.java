class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        int start = len - 1;
        int end = 0;
        int tank = gas[start] - cost[start];

        while (start > end) {
            // If tank is negative, means we can only go backwards to "refill"
            if (tank < 0) {
                start--;
                tank += gas[start] - cost[start];
            } else {
                // We can move forward;
                tank += gas[end] - cost[end];
                end++;
            }
        }

        return tank >= 0 ? start : -1;
    }
}