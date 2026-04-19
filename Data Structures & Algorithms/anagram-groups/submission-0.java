class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to keep track of a string and its corresponding anagrams
        Map<Map<Character, Integer>, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            Map<Character, Integer> charMap = getCharacterMap(str);

            if (!anagramMap.containsKey(charMap)) {
                anagramMap.put(charMap, new ArrayList<>());
            }
            anagramMap.get(charMap).add(str);
        }

        return anagramMap.values().stream().toList();

    }

    private Map<Character, Integer> getCharacterMap(String str) {
        Map<Character, Integer> characterMap = new HashMap<>();

        for (int i = 0; i < str.length(); i ++) {
            Character currChar = str.charAt(i);
            characterMap.put(currChar, characterMap.getOrDefault(currChar, 0) + 1);
        }

        return characterMap;
    }
}
