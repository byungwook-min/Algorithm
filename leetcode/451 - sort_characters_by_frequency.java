class Solution {
    public String frequencySort(String s) {
        
        Map<Character, Long> frequencies = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return frequencies.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .map(e -> String.valueOf(e.getKey()).repeat(e.getValue().intValue()))
                .collect(Collectors.joining());
    }
}