class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int cnt = 1;

        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                ans += cnt;
                continue;
            }

            if (prices[i] == prices[i - 1] - 1) {
                cnt++;
            } else {
                cnt = 1;
            }

            ans += cnt;
        }

        return ans;
    }
}