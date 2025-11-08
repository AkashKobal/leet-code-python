class Solution {
    public int minimumOneBitOperations(int n) {
        for (int k = 1; k <= 16; k *= 2) {
            n ^= (n >> k);}
        return n;}
}