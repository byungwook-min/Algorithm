class LFUCache {

    private static class Node {
        int key, value, count = 1;

        Node(int key, int value) {
            this.key = key; this.value = value;
        }
    }

    private final Map<Integer, Node> cache = new HashMap<>();
    private final Map<Integer, LinkedHashSet<Node>> nodesByFrequency = new HashMap<>();
    private final int capacity;
    private int minFrequency = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        increaseCount(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            increaseCount(node);
            return;
        }
        if (cache.size() == capacity) {
            LinkedHashSet<Node> leastFrequentNodes = nodesByFrequency.get(minFrequency);
            Node dead = leastFrequentNodes.iterator().next();
            leastFrequentNodes.remove(dead);
            cache.remove(dead.key);
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        nodesByFrequency.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(newNode);
        minFrequency = 1;
    }

    private void increaseCount(Node node) {
        int currentFrequency = node.count;
        LinkedHashSet<Node> currentNodes = nodesByFrequency.get(currentFrequency);
        currentNodes.remove(node);

        if (currentFrequency == minFrequency && currentNodes.isEmpty()) {
            minFrequency++;
        }

        node.count++;
        nodesByFrequency.computeIfAbsent(node.count, k -> new LinkedHashSet<>()).add(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
