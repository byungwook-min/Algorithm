class RecentCounter {

    private final Deque<Integer> requestTimes;

    public RecentCounter() {
        this.requestTimes = new ArrayDeque<>();
    }

    public int ping(int t) {
        requestTimes.addLast(t);

        while (t - requestTimes.getFirst() > 3000) {
            requestTimes.removeFirst();
        }
        return requestTimes.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
