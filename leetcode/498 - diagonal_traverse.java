class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] result = new int[m * n];
        int idx = 0;

        for (int k = 0; k < m + n - 1; k++) {
            if (k % 2 == 0) {
                int r = Math.min(k, m - 1);
                while (r >= 0 && (k - r) < n) {
                    result[idx++] = mat[r][k - r];
                    r--;
                }
            } else {
                int r = Math.max(0, k - (n - 1));
                while (r < m && (k - r) >= 0) {
                    result[idx++] = mat[r][k - r];
                    r++;
                }
            }
        }
        return result;
    }
}
