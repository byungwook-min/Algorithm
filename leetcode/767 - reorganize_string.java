class Solution {
    public String reorganizeString(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        int mostFrequent = 0;
        for (int i = 1; i < 26; i++) {
            if (counts[i] > counts[mostFrequent]) {
                mostFrequent = i;
            }
        }

        if (counts[mostFrequent] > (s.length() + 1) / 2) return "";

        char[] result = new char[s.length()];
        int index = 0;

        while (counts[mostFrequent] > 0) {
            result[index] = (char) ('a' + mostFrequent);
            index += 2;
            counts[mostFrequent]--;
        }

        for (int i = 0; i < 26; i++) {
            while (counts[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                result[index] = (char) ('a' + i);
                index += 2;
                counts[i]--;
            }
        }

        return new String(result);
    }
}
