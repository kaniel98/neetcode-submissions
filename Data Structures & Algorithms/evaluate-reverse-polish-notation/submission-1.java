class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        Set<String> notations = new HashSet<>(List.of("+", "*", "-", "/"));

        for (String token : tokens) {
            if (notations.contains(token)) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(evaluateResult(token, first, second));
                continue; 
            }

            stack.push(Integer.valueOf(token));
        }

        return stack.pop();
    }

    public int evaluateResult(String operation, Integer first, Integer second) {
        if (operation.equals("+")) {
            return first + second;
        } else if (operation.equals("-")) {
            return first - second;
        } else if (operation.equals("*")) {
            return first * second;
        } else {
            return first / second;
        }
    }
}
