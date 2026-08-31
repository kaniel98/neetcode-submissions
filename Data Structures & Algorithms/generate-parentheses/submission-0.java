class Solution {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        // Pattern is that we need to maintain equal open and closing
        // keep a count of open and close, the moment both 0, means we finished
        // Additionally, we must always ensure open <= close, never close > open
        StringBuilder sb = new StringBuilder();
        generateParenthesisDfs(sb, n, n);

        return result;
    }

    public void generateParenthesisDfs(StringBuilder sb, int open, int close) {
        if (open == 0 && close == 0) {
            result.add(sb.toString());
            return;
        }

        if (open > 0) {
            sb.append('(');
            generateParenthesisDfs(sb, open - 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }   

        if (close > 0 && close > open) {
            sb.append(')');
            generateParenthesisDfs(sb, open, close - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
