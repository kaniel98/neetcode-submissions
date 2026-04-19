class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<String, Set<Character>> sqaures = new HashMap<>();

        // Iterate through the columns and rows 
        for (int c = 0; c < board.length; c ++) {
            for (int r = 0; r < board[0].length; r ++) {
                if (board[r][c] == '.') {
                    continue; // Skip this round
                }

                Character chr = board[r][c];
                String sqKey = (r / 3) + "," + (c / 3);
                if (
                    rows.computeIfAbsent(r, k -> new HashSet<>()).contains(chr) ||
                    columns.computeIfAbsent(c, k -> new HashSet<>()).contains(chr) || 
                    sqaures.computeIfAbsent(sqKey, k -> new HashSet<>()).contains(chr)
                ) {
                    return false;
                }

                rows.get(r).add(chr);
                columns.get(c).add(chr);
                sqaures.get(sqKey).add(chr);
            }
        }       

        return true;  
    }
}
