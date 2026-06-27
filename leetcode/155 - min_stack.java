class MinStack {

    private final Deque<Integer> values;
    private final Deque<Integer> minimums;

    public MinStack() {
        values = new ArrayDeque<>();
        minimums = new ArrayDeque<>();
    }

    public void push(int value) {
        values.push(value);
        if (minimums.isEmpty()) {
            minimums.push(value);
        } else {
            minimums.push(Math.min(value, minimums.peek()));
        }
    }

    public void pop() {
        values.pop();
        minimums.pop();
    }

    public int top() {
        return values.peek();
    }

    public int getMin() {
        return minimums.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
