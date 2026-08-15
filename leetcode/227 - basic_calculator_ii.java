class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        Deque<Integer> stack = new ArrayDeque<>();

        int cur = 0;
        char operation = '+';
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;

            if (Character.isDigit(c)) {
                cur = cur * 10 + (c - '0');
            }
            else {
                process(stack, operation, cur);
                operation = c;
                cur = 0;
            }
        }
        process(stack, operation, cur);

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    private void process(Deque<Integer> stack, char op, int num) {
        if (op == '+') stack.push(num);
        else if (op == '-') stack.push(-num);
        else if (op == '*') stack.push(stack.pop() * num);
        else if (op == '/') stack.push(stack.pop() / num);
    }
}
