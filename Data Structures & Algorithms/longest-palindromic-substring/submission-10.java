class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s; 
        }

        String resString = ""; 
        for (int i = 0; i < s.length(); i ++) {
            String stringOne = getPalindrome(s, i, i);
            String stringTwo = getPalindrome(s, i, i + 1);

            if (stringOne.length() > resString.length()) {
                resString = stringOne; 
            }
            if (stringTwo.length() > resString.length()) {
                resString = stringTwo; 
            }
        }

        return resString;
    }

    public String getPalindrome(String s, int left, int right) {
        if (left == right) {
            left --;
            right ++; 
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++; 
        }

        return s.substring(left + 1, right);
    }
}