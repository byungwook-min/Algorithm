class Solution {

    private record Element(int value, int index) {}

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        List<Element> elements = new ArrayList();
        for (int i = 0; i < n; i++) {
            elements.add(new Element(nums[i], i));
        }
        elements.sort(Comparator.comparingInt(Element::value));

        int low = 0; int high = n - 1;
        while (low < high) {
            long sum = (long) elements.get(low).value() + elements.get(high).value();
            if (sum == target) return new int[]{elements.get(low).index(), elements.get(high).index()};
            if (sum < target) {
                low++;
                continue;
            }
            high--;
        }
        return new int[]{-1, -1};
    }
}
