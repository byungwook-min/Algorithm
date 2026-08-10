class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int current = 0;
        for (int i = 0; i < k; i++) {
            current += nums[i];
        }

        int max = current;
        for (int i = k; i < nums.length; i++) {
            current += nums[i] - nums[i - k];
            max = Math.max(max, current);
        }

        return (double) max / k;
    }
}
