class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> ref = getCharacterMap(s1);
        Map<Character, Integer> s2Map = new HashMap();

        int matches = 0; 
        int start = 0;

        // Populate with it first
        for (int i = 0; i < s1.length(); i ++) {
            Character chr = s2.charAt(i);
            s2Map.put(chr, s2Map.getOrDefault(chr, 0) + 1);
        }

        for (Character chr : ref.keySet()) {
            if (ref.get(chr).equals(s2Map.get(chr))) {
                matches ++; 
            }
        }

        for (int end = s1.length(); end < s2.length(); end ++) {
            if (matches == ref.keySet().size()) {
                return true; 
            }
            
            // Else we will move the window 
            Character endChr = s2.charAt(end); 
            if (ref.containsKey(endChr)) {
                int oldVal = s2Map.getOrDefault(endChr, 0);
                if (ref.get(endChr) == oldVal) matches--;
                s2Map.put(endChr, oldVal + 1);
                if (ref.get(endChr).equals(s2Map.get(endChr))) matches++; 
            } else {
                s2Map.put(endChr, s2Map.getOrDefault(endChr, 0) + 1);
            }

            Character startChr = s2.charAt(start);
            if (ref.containsKey(startChr)) {
                int oldVal = s2Map.get(startChr);
                if (ref.get(startChr).equals(oldVal)) matches--;
                s2Map.put(startChr, oldVal - 1);
                if (ref.get(startChr).equals(s2Map.get(startChr))) matches++;
            } else {
                s2Map.put(startChr, s2Map.get(startChr) - 1);
            }
            start++;
        }

        return matches == ref.keySet().size();
    }

    private Map<Character, Integer> getCharacterMap(String original) {
        Map<Character, Integer> res = new HashMap<>();

        for (Character chr : original.toCharArray()) {
            res.put(chr, res.getOrDefault(chr, 0) + 1);
        }

        return res;
    }
}