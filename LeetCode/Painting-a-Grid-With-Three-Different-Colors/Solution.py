new_dp = [0]*S
for i in range(S):
    if dp[i]:
        for j in compat[i]:
            new_dp[j] = (new_dp[j] + dp[i]) % MOD
dp = new_dp