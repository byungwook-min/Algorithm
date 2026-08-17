class TimeMap {

    private record Node(int timestamp, String value) {}

    Map<String, List<Node>> timeMap;

    public TimeMap() {
        this.timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Node> list = timeMap.get(key);
        if (list == null || list.isEmpty() || list.get(0).timestamp() > timestamp) {
            return "";
        }

        int left = 0;
        int right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp() <= timestamp) {
                result = list.get(mid).value();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
