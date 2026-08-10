class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for (Character chr : s.toCharArray()) {
            if (!map.containsKey(chr)){
                stack.push(chr);
                continue;
            }

            if (stack.isEmpty()){
                return false;
            }

            Character openChr = stack.pop();
            if (openChr != map.get(chr)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
