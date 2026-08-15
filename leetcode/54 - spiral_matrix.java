class Solution {

    private static final int dx[] = { 0, 1, 0, -1 };
    private static final int dy[] = { 1, 0, -1, 0 };

    private record Position(int row, int col) {}

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col++) result.add(matrix[top][col]);
            top++;

            for (int row = top; row <= bottom; row++) result.add(matrix[row][right]);
            right--;

            if (top > bottom) continue;
            for (int col = right; col >= left; col--) result.add(matrix[bottom][col]);
            bottom--;

            if (left > right) continue;
            for (int row = bottom; row >= top; row--) result.add(matrix[row][left]);
            left++;
        }
        return result;
    }
}
