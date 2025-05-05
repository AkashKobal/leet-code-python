class Solution:
    def numTilings(self, n: int) -> int:
        MOD = 10**9 + 7
        
        if n == 0:
            return 1
        if n < 3:
            return n

        full_cover = [0] * (n + 1)
        l_shaped_partial = [0] * (n + 1)
        
        full_cover[0] = 1
        full_cover[1] = 1
        full_cover[2] = 2
        l_shaped_partial[2] = 1
        
        for width in range(3, n + 1):
            full_cover[width] = (
                full_cover[width - 1]
                + full_cover[width - 2]
                + 2 * l_shaped_partial[width - 1]
            ) % MOD

            l_shaped_partial[width] = (
                l_shaped_partial[width - 1]
                + full_cover[width - 2]
            ) % MOD
        
        return full_cover[n]         