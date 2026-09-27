class Solution {
    
    List<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        dfs(map, new ArrayList<>());
        return result;
    }

    public void dfs(Map<Integer, Integer> map, List<Integer> current) {
        if (map.isEmpty()) {
            result.add(new ArrayList<>(current));
        }

        List<Integer> nums = new ArrayList<>(map.keySet());
        for (int num :nums) {
            current.add(num); 
            if (map.get(num) == 1) {
                map.remove(num); 
            } else {
                map.put(num, map.get(num) - 1);
            }
            dfs(map, current); 
            
            // Reset for next;
            current.removeLast();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

}