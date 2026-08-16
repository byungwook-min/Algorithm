class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {
            basket.merge(fruits[right], 1, Integer::sum);

            while (basket.size() > 2) {
                basket.compute(fruits[left], (k, count) -> count == 1 ? null : count - 1);
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}
