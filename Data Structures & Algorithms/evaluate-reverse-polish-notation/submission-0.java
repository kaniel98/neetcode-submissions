class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        Set<String> operations = new HashSet<>(List.of("+", "-", "*", "/"));

        for (String str : tokens) {
            if (operations.contains(str)) {
                executeOperation(str, stack);
                continue;
            }
            
            stack.push(Integer.parseInt(str));
        }

        return stack.pop();
    }

    public void executeOperation(String operation, Stack<Integer> stack) {
        int right = stack.pop();
        int left = stack.pop();

        if (operation.equals("+")) {
            stack.push(left + right);            
        } else if (operation.equals("-")) {
            stack.push(left - right);
        } else if (operation.equals("*")) {
            stack.push(left * right);
        } else {
            stack.push(left / right);
        }
    }
}
