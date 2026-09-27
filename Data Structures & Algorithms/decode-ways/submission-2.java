class Solution {
    int[] ways;

    public int numDecodings(String s) {
        ways = new int[s.length() + 1];    
        Arrays.fill(ways, -1);

        return dfs(s, 0);
    }

    public int dfs(String s, int idx) {
        if (idx == s.length()) {
            return 1;
        }

        if (ways[idx] != -1) {
            return ways[idx];
        }

        if (s.charAt(idx) == '0') {
            return ways[idx] = 0;
        }

        int currWay = dfs(s, idx + 1);

        if (idx + 1 < s.length()
            && (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) < '7'))) {
            currWay += dfs(s, idx + 2);
        }

        return ways[idx] = currWay;
    }
}
