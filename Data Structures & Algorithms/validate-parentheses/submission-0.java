class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> openCloseMap = new HashMap<>();
        openCloseMap.put(']', '[');
        openCloseMap.put('}', '{');
        openCloseMap.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for (Character chr : s.toCharArray()) {
            if (openCloseMap.containsKey(chr)) {
                if (!stack.isEmpty() && stack.peek() == openCloseMap.get(chr)) {
                    stack.pop();
                } else {
                    return false; 
                }
            } else {
                stack.push(chr);
            }
        }

        return stack.isEmpty();
    }
}
