class MyHashSet {

    private static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    private static final int BUCKET_SIZE = 10_007;
    private final Node[] buckets;

    public MyHashSet() {
        buckets = new Node[BUCKET_SIZE];
    }

    private int getHash(int key) {
        return key % BUCKET_SIZE;
    }

    public void add(int key) {
        int hash = getHash(key);

        if (buckets[hash] == null) {
            buckets[hash] = new Node(-1);
        }

        Node previousNode = buckets[hash];
        while (previousNode.next != null) {
            if (previousNode.next.key == key) {
                return;
            }
            previousNode = previousNode.next;
        }
        previousNode.next = new Node(key);
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

    public boolean contains(int key) {
        int hash = getHash(key);

        Node currentNode = buckets[hash];
        if (currentNode == null) return false;

        while (currentNode != null) {
            if (currentNode.key == key) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
