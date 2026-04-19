class Solution {
    public boolean isAnagram(String s, String t) {
        // Edge cases 
        if (s.length() != t.length()) {
            return false;
        }

        // Hashmap to maintain a count of the characters
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < s.length(); i ++) {
            Character currentChar = s.charAt(i);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
        }

        for (int i = 0; i < t.length(); i ++) {
            Character currentChar = t.charAt(i);
            if (!charCount.containsKey(currentChar)) {
                return false;
            }
            charCount.put(currentChar, charCount.get(currentChar) - 1);
            if (charCount.get(currentChar) == 0) {
                charCount.remove(currentChar);
            }
        }

        return charCount.isEmpty();
    }
}
