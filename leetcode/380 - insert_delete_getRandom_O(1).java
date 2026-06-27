class RandomizedSet {

    private final List<Integer> values;
    private final Map<Integer, Integer> indices;
    private final Random random;

    public RandomizedSet() {
        this.values = new ArrayList<>();
        this.indices = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }

        indices.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }

        int targetPosition = indices.get(val);
        int lastValue = values.get(values.size() - 1);

        values.set(targetPosition, lastValue);
        indices.put(lastValue, targetPosition);

        values.remove(values.size() - 1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(values.size());
        return values.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
