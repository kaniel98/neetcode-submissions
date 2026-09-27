class Solution {
    public String minRemoveToMakeValid(String s) {
        // Stack to keep track of the parenthesis 
        // Too many ), remove it 
        // Too many (, remove remainder in the stack
        // If ) arrives when stack is empty, also remove
        // Set of integer to know the position to skip
        // At the end, reconstruct the string

        Set<Integer> toBeSkipped = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i ++) {
            Character chr = s.charAt(i);
            if (chr != '(' && chr != ')') {
                continue; 
            }

            if (chr == '(') {
                stack.add(i);
                continue;
            }

            if (stack.isEmpty()) {
                toBeSkipped.add(i); // To be skipped later
                continue;
            }

            // Else pop
            stack.pop();
        }

        // At the end, add the remainder in the stack to be skipped
        toBeSkipped.addAll(stack);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            if (toBeSkipped.contains(i)) {
                continue; 
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}