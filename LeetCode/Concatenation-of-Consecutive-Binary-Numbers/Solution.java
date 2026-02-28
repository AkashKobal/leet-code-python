class Solution {
    public int concatenatedBinary(int n) {
        final long MOD = (long)(1e9 + 7);
        long res = 0;
        for (int i = 1; i <= n; i++) {
            int bits = 32 - Integer.numberOfLeadingZeros(i);
            res = ((res << bits) + i) % MOD;
        }

        return (int)res;
    }
}