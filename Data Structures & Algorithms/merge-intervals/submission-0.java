class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals based on start, followed by last 
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Maintain an array 
        List<int[]> arr = new ArrayList<>();

        // Start from the start of the interval, push the first one in
        for (int[] interval : intervals) {
            if (arr.size() == 0) {
                arr.add(interval);
                continue;
            }

            int[] lastInterval = arr.get(arr.size() -1);
            if (lastInterval[1] < interval[0]) {
                arr.add(interval);
            } else {
                // Merge
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
        }

        int[][] res = new int[arr.size()][];
        return arr.toArray(res);
    }
}
