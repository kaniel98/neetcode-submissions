class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }

        int left = 0;
        int right = s.length() -1;

        while (left < right) {
            // Adjust left to alpha num
            while (left < right && !isAlphaNum(s, left)) {
                left ++;
            }

            while (left < right && !isAlphaNum(s, right)) {
                right --;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left ++;
            right --;
        }

        return true;
    }

    public boolean isAlphaNum(String s, int pointer) {
        return Character.isLetterOrDigit(s.charAt(pointer));
    }
}
