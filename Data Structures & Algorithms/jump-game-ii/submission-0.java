class Solution {
    int[] minJumps;

    public int jump(int[] nums) {
        // Initialize the minJumps
        minJumps = new int[nums.length];
        Arrays.fill(minJumps, Integer.MAX_VALUE);
        
        findMinJump(nums, 0, 0);

        return minJumps[minJumps.length - 1];
    }

    private void findMinJump(int[] nums, int position, int jumpsTaken) {
        // Base case 
        if (jumpsTaken >= minJumps[position]) {
            return;
        }

        // Else update 
        minJumps[position] = jumpsTaken;

        // Handle the return case
        if (position == nums.length -1) {
            return;
        }
    
        int lastPoint = Math.min(nums.length - 1, position + nums[position]);
        for (int i = lastPoint; i > position; i --) {
            findMinJump(nums, i, jumpsTaken + 1);
        }
    }
}