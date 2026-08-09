class Solution {

    private static final int[] ROW_DIRECTIONS = { 1, 0, -1, 0 };
    private static final int[] COL_DIRECTIONS = { 0, 1, 0, -1 };

    private record Position(int row, int col) {}

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];

        if (initialColor == color) return image;

        int rowCount = image.length;
        int colCount = image[0].length;

        Queue<Position> queue = new ArrayDeque<>();

        image[sr][sc] = color;
        queue.offer(new Position(sr, sc));

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nextRow = current.row() + ROW_DIRECTIONS[dir];
                int nextCol = current.col() + COL_DIRECTIONS[dir];

                if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount) continue;
                if (image[nextRow][nextCol] != initialColor) continue;
                if (image[nextRow][nextCol] == color) continue;
                image[nextRow][nextCol] = color;
                queue.offer(new Position(nextRow, nextCol));
            }
        }
        return image;
    }
}
