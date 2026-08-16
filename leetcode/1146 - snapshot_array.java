class SnapshotArray {

    private record Entry(int snapId, int value) {}

    private final List<List<Entry>> history;
    private int snapId;

    public SnapshotArray(int length) {
        this.history = new ArrayList<>(length);
        this.snapId = 0;

        for (int i = 0; i < length; i++) {
            List<Entry> list = new ArrayList<>();
            list.add(new Entry(0, 0));
            history.add(list);
        }
    }

    public void set(int index, int val) {
        List<Entry> list = history.get(index);
        Entry last = list.get(list.size() - 1);

        if (last.snapId() == snapId) {
            list.set(list.size() - 1, new Entry(snapId, val));
        } else {
            list.add(new Entry(snapId, val));
        }
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        List<Entry> list = history.get(index);

        int left = 0;
        int right = list.size() - 1;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Entry entry = list.get(mid);

            if (entry.snapId() <= snap_id) {
                result = entry.value();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
