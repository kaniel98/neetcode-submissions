class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // Work from bottom up
        // row
        for (int idxOne = text1.length() -1; idxOne >= 0; idxOne --) {
            for (int idxTwo = text2.length() -1; idxTwo >= 0; idxTwo --) {
                // Two situations
                // If both character matches
                if (text1.charAt(idxOne) == text2.charAt(idxTwo)) {
                    dp[idxOne][idxTwo] = 1 + dp[idxOne + 1][idxTwo + 1];
                } else {
                    // We would just take the max from the right side or bottom
                    dp[idxOne][idxTwo] = Math.max(dp[idxOne][idxTwo + 1], dp[idxOne + 1][idxTwo]);
                }
            }
        }

        return dp[0][0];
    }
}
