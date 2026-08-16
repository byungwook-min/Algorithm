import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    private static final int[] dx = { 1, -1, 0, 0 };
    private static final int[] dy = { 0, 0, 1, -1 };

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{ i, j });
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int minutes = 0;
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            minutes++;

            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];

                for (int dir = 0; dir < 4; dir++) {
                    int nr = r + dx[dir];
                    int nc = c + dy[dir];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshCount--;
                        queue.offer(new int[]{ nr, nc });
                    }
                }
            }
        }

        return freshCount == 0 ? minutes : -1;
    }
}
