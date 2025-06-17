class Solution:
    def countGoodArrays(self, n: int, m: int, k: int) -> int:
        MOD = pow(10,9)+7

        dp = {}
        def backtrack(cur_n, cur_k, lastNum):
            if (cur_n, cur_k, lastNum) in dp:
                return dp[(cur_n, cur_k, lastNum)] 

            if cur_n==n:
                return 1 if cur_k == k else 0
            
            res = 0
            for cur_m in range(1, m+1):
                if cur_m==lastNum:
                    res += backtrack(cur_n+1, cur_k+1, cur_m)
                else:
                    res += backtrack(cur_n+1, cur_k, cur_m)

            dp[(cur_n, cur_k, lastNum)] = res % MOD
            return dp[(cur_n, cur_k, lastNum)]

        return backtrack(0,0,0)