class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < dislikes.length; i++) {
            int a = dislikes[i][0];
            int b = dislikes[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] color = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !bfs(i, graph, color)) {
                return false;
            }
        }

        return true;
    }

    private boolean bfs(int start, List<List<Integer>> graph, int[] color) {
        Queue<Integer> queue = new ArrayDeque<>();
        color[start] = 1;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (color[neighbor] == color[node]) {
                    return false;
                }

                if (color[neighbor] == 0) {
                    color[neighbor] = 3 - color[node];
                    queue.offer(neighbor);
                }
            }
        }

        return true;
    }
}
