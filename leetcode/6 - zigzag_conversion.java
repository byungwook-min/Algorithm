class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        int dir = 1;
        int idx = 0;

        while (idx < s.length()) {
            rows[row].append(s.charAt(idx));

            if (row == 0) {
                dir = 1;
            } else if (row == numRows - 1) {
                dir = -1;
            }

            row += dir;
            idx++;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb: rows) {
            result.append(sb);
        }
        return result.toString();
    }
}
