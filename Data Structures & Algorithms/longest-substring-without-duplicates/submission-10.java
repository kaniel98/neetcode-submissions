class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashSet to keep track of appeared characters
        // Start and end pointers 
        
        Map<Character, Integer> appeared = new HashMap<>();

        int start = 0;
        int end = 0; 
        int res = 0; 

        while (end < s.length()) {
            Character chr = s.charAt(end); 

            if (appeared.containsKey(chr)) {
                res = Math.max(res, end - start);
                start = Math.max(start, appeared.get(chr) + 1); 
            }

            appeared.put(chr, end);
            end ++;
        }      

        System.out.println(start);
        return Math.max(res, end - start); 
    }
}
