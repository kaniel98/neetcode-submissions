class Solution {
    
    int[][] dp;
    String word1;
    String word2; 

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length()); 
        }

        // construct an array where 
        dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < dp.length; i ++) {
            Arrays.fill(dp[i], -1); 
        }
        
        this.word1 = word1;
        this.word2 = word2;

        return minDfs(0, 0);
    }

    public int minDfs(int posOne, int posTwo) {
        if (posOne == word1.length()) {
            return word2.length() - posTwo;
        }

        if (posTwo == word2.length()) {
            return word1.length() - posOne;
        }

        if (dp[posOne][posTwo] != -1) {
            return dp[posOne][posTwo]; 
        }

        // Same, means both move
        if (word1.charAt(posOne) == word2.charAt(posTwo)) {
            return dp[posOne][posTwo] = minDfs(posOne + 1, posTwo + 1);
        }

        // Delete (posOne + 1), Insert (posTwo + 1), Replace (posOne + 1, posTwo + 1)
        int operations = 1 + Math.min(minDfs(posOne + 1, posTwo), 
                             Math.min(minDfs(posOne, posTwo + 1), 
                                      minDfs(posOne + 1, posTwo + 1)));

        return dp[posOne][posTwo] = operations;
    }
}