class Solution {
    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) return s;

        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        List<Character> characters = new ArrayList<>(frequencies.keySet());
        characters.sort((a, b) -> frequencies.get(b) - frequencies.get(a));

        StringBuilder sorted = new StringBuilder();
        for (char c : characters) {
            int count = frequencies.get(c);
            while (count-- > 0) {
                sorted.append(c);
            }
        }

        return sorted.toString();
    }
}
