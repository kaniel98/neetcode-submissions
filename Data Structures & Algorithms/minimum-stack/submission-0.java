class MinStack {

    private List<Integer> stack; 
    private List<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.minStack = new ArrayList<>();    
    }
    
    public void push(int val) {
        this.stack.add(val);

        // Add to the minStack 
        if (this.minStack.size() == 0) {
            // It is the min at index 0
            this.minStack.add(val); 
            return;
        }

        // Else, check which is the smallest
        int min = Math.min(val, minStack.get(minStack.size() - 1));
        minStack.add(min);
    }
    
    public void pop() {
        stack.removeLast();
        minStack.removeLast();
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return minStack.get(minStack.size() - 1);
    }
}
