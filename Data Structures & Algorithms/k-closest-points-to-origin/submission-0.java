class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Calculate distance
        int x2 = 0;
        int y2 = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingDouble(p -> 
                Math.sqrt(Math.pow(p[0] - x2, 2) + Math.pow(p[1] - y2, 2))
            )
        );

        // Put into a min heap
        for (int i = 0; i < points.length; i ++) {
            minHeap.add(points[i]);
        }


        int[][] res = new int[k][];

        for (int i = 0; i < k; i ++) {
            res[i] = minHeap.poll();
        }

        return res;
    }

}
