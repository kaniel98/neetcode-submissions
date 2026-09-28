class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            lastIndexMap.put(s.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>(); 

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i ++) {
            Character chr = s.charAt(i);
            int chrEnding = lastIndexMap.get(chr);
            end = Math.max(end, chrEnding);

            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}