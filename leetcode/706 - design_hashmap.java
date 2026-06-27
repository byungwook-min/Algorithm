class MyHashMap {

    private static class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private static final int BUCKET_SIZE = 10007;
    private final Node[] buckets;

    public MyHashMap() {
        this.buckets = new Node[BUCKET_SIZE];
    }

    private int getHash(int key) {
        return key % BUCKET_SIZE;
    }

    public void put(int key, int value) {
        int hash = getHash(key);

        if (buckets[hash] == null) {
            buckets[hash] = new Node(-1, -1);
        }

        Node previousNode = buckets[hash];
        while (previousNode.next != null) {
            if (previousNode.next.key == key) {
                previousNode.next.val = value;
                return;
            }
            previousNode = previousNode.next;
        }
        previousNode.next = new Node(key, value);
    }

    public int get(int key) {
        int hash = getHash(key);
        Node currentNode = buckets[hash];

        if (currentNode == null) return -1;

        currentNode = currentNode.next;
        while (currentNode != null) {
            if (currentNode.key == key) {
                return currentNode.val;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = getHash(key);
        Node previousNode = buckets[hash];

        if (previousNode == null) return;

        while (previousNode.next != null) {
            if (previousNode.next.key == key) {
                previousNode.next = previousNode.next.next;
                return;
            }
            previousNode = previousNode.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
