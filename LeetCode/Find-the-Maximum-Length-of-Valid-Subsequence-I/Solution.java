int solve(vector<int>& nums, int ind, int prev, int x, vector<vector<int>>& dp) {
    if (ind == nums.size()) return 0;

    if (dp[ind][prev + 1] != -1)
        return dp[ind][prev + 1];

    int exc = solve(nums, ind + 1, prev, x, dp);
    int inc = 0;

    if (prev == -1 || (nums[ind] + nums[prev]) % 2 == x) {
        inc = 1 + solve(nums, ind + 1, ind, x, dp);
    }

    return dp[ind][prev + 1] = max(exc, inc);
}