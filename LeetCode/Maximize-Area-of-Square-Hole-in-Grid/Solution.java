class Solution {
    private int maxLen(int[] Bars) {
        int count = 2, length = 2;
        for(int i = 1; i < Bars.length; i++) {
            if(Bars[i] - Bars[i-1] == 1) count++;
            else count = 2;
            length = Math.max(length, count);
        }
        return length;
    }
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int side = Math.min(maxLen(hBars), maxLen(vBars));
        return side * side; 
    }
}