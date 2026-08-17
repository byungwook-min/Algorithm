class RecentCounter {

    private final Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.offer(t);

        while (t - queue.peek() > 3000) {
            queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
