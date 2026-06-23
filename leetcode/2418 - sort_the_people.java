class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        return IntStream.range(0, names.length)
            .boxed()
            .sorted((a, b) -> Integer.compare(heights[b], heights[a]))
            .map(idx -> names[idx])
            .toArray(String[]::new);
    }
}