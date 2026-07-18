class Solution {
    public int characterReplacement(String s, int k) {
        // Criteria: Two characters only, one of it can only be up to K
        Map<Character, Integer> count = new HashMap<>();

        int left = 0;
        int res = 0;
        int maxf = 0; 

        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i ++) {
            Character chr = charArray[i];
            count.put(chr, count.getOrDefault(chr, 0) + 1);
            maxf = Math.max(maxf, count.get(chr));

            // maxf never has to be decremented
            // the res will only eever increase if maxf is increased, never decreased
            while ((i - left + 1) - maxf > k) {
                Character leftChr = charArray[left];
                count.put(leftChr, count.get(leftChr) -1);
                left ++;
            }
            res = Math.max(res, i - left + 1);
        }

        return res;
    }
}