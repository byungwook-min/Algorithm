class Solution {
    private static final int[] dx = { 1, 0, -1, 0 };
    private static final int[] dy = { 0, 1, 0, -1 };

    private record Position(int x, int y) {}

    public int shortestBridge(int[][] grid) {
        int n = grid.length;

        findAndMarkFirstIsland(grid, n);

        Queue<Position> queue = new ArrayDeque<>();
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Position(i, j));
                    dist[i][j] = 0;
                    continue;
                }
                dist[i][j] = -1;
            }
        }

        while (!queue.isEmpty()) {
            Position cur = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (isOut(nx, ny, n)) continue;

                if (grid[nx][ny] == 2) {
                    return dist[cur.x][cur.y];
                }

                if (dist[nx][ny] != -1) continue;
                if (grid[nx][ny] == 1) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                queue.offer(new Position(nx, ny));
            }
        }

        return -1;
    }

    private void findAndMarkFirstIsland(int[][] grid, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    markIsland(grid, i, j, n);
                    return;
                }
            }
        }
    }

    private void markIsland(int[][] grid, int r, int c, int n) {
        Queue<Position> q = new ArrayDeque<>();
        q.offer(new Position(r, c));
        grid[r][c] = 2;

        while (!q.isEmpty()) {
            Position cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (!isOut(nx, ny, n) && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                }
            }
        }
    }

    private boolean isOut(int x, int y, int n) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }
}
