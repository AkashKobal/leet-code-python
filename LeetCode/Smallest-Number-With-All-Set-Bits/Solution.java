class Solution {
    public int smallestNumber(int n) {
        for (int i = 0; i <= n; i++) {
            int z = 1 << i;
            if (z > n) return z - 1;
        }
        return 0;
    }
}