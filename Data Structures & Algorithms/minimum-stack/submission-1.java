class MinStack {

    // Two seperate Stacks 
    // 1. Keep track of the numbers in the stack
    List<Integer> stack;
    // 2. Keep track of the minimum value in the stack at the given position
    List<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);

        if (minStack.size() == 0) {
            minStack.add(val);
        } else {
            int prevSmallest = minStack.getLast();
            if (prevSmallest > val) {
                minStack.add(val);
            } else {
                minStack.add(prevSmallest);
            }
        }

    }
    
    public void pop() {
        stack.removeLast();
        minStack.removeLast();
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return minStack.getLast();
    }
}
