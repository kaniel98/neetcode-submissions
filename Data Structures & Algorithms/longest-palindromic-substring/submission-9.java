class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String resString = s.substring(0, 1); 

        for (int i = 0; i < s.length(); i ++) {
            String s1 = getPalindromeLength(s, i, i);
            String s2 = getPalindromeLength(s, i, i + 1);
            
            if (s1.length() > resString.length()) resString = s1;
            if (s2.length() > resString.length()) resString = s2;
        }

        return resString;
    }

    public String getPalindromeLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}