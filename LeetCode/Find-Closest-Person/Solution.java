class Solution {
    public int findClosest(int x, int y, int z) {
        int d1 = Math.abs(z - x);
        int d2 = Math.abs(z - y);

        if (d1 < d2) return 1;
        else if (d2 < d1) return 2;
        else return 0;
    }
}