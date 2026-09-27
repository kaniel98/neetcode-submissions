class Solution {
    public int numDecodings(String s) {
        int[] ways = new int[s.length() + 1];

        ways[s.length()] = 1; // Starting number

        // Work from behind
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                ways[i] = 0;
                continue;
            }

            ways[i] += ways[i + 1];
            if (i + 1 < s.length()
                && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                // Then at this point
                ways[i] += ways[i + 2];
            }
        }

        return ways[0];
    }
}
