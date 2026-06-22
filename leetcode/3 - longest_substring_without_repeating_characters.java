class Solution {

    public int lengthOfLongestSubstring(String s) {
        int[] lastSeenAt = new int[128];
        Arrays.fill(lastSeenAt, -1);
        int windowStart = 0;
        int maxLength = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            windowStart = Math.max(windowStart, lastSeenAt[c] + 1);
            lastSeenAt[c] = end;
            maxLength = Math.max(maxLength, end - windowStart + 1);
        }
        return maxLength;
    }
}
