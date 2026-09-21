class Solution {
    public boolean checkValidString(String s) {
        int leftMax = 0;
        int leftMin = 0;

        for (Character chr : s.toCharArray()) {
            if (chr == '(') {
                leftMin ++;
                leftMax ++;
            }

            if (chr == '*') {
                leftMax ++;
                // But minimum can decrease
                leftMin --;
            }

            if (chr == ')') {
                leftMax --;
                leftMin --;
            }

            if (leftMax < 0) {
                return false;
            }

            leftMin = Math.max(0, leftMin);
        }

        return leftMin == 0;
    }
}