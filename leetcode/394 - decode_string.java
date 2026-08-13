class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        int k = 0;

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
                continue;
            }
            if (c == '[') {
                countStack.push(k);
                stringStack.push(sb);

                k = 0;
                sb = new StringBuilder();
                continue;
            }
            if (c == ']') {
                StringBuilder prev = stringStack.pop();
                int count = countStack.pop();

                for (int i = 0; i < count; i++) {
                    prev.append(sb);
                }
                sb = prev;
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
