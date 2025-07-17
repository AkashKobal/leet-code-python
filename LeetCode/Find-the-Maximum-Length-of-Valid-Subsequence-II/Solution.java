class Solution {
    public int solve(int prev, int curr, int n, int k, int[] nums, int[][] dp) {
        if (curr >= n - 1) {
            return 0;
        }
        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }

        if (prev == -1) {
            int notTake = solve(prev, curr + 1, n, k, nums, dp);
            int take = Integer.MIN_VALUE;

            for (int j = curr + 1; j < n; j++) {
                take = Math.max(take, 2 + solve((nums[curr] + nums[j]) % k, j, n, k, nums, dp));
            }

            return dp[curr][prev + 1] = Math.max(take, notTake);
        }

        for (int j = curr + 1; j < n; j++) {
            if ((nums[curr] + nums[j]) % k == prev) {
                return dp[curr][prev + 1] = 1 + solve(prev, j, n, k, nums, dp);
            }
        }
        return dp[curr][prev + 1] = 0;
    }

    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) return 0;
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(-1, 0, n, k, nums, dp);
    }
}
