class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        s = s.replace(" ", "");
        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (Character.isDigit(chr)) {
                num = num * 10 + (chr - '0');
            }
            if (!Character.isDigit(chr) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    int prev = stack.pop();
                    stack.push(prev * num);
                } else if (sign == '/') {
                    int prev = stack.pop();
                    stack.push(prev / num);
                }
                sign = chr;
                num = 0;
            }
        }

        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}