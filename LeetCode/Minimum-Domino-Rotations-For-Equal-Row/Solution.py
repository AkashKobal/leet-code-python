class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        n = len(tops)
        X, Y = tops[0], bottoms[0]
        hasX = hasY = True
        swapXB = swapXT = 0 
        swapYB = swapYT = 0  

        for i in range(n):
            # Check for value X
            if hasX:
                if tops[i] != X and bottoms[i] != X:
                    hasX = False
                else:
                    if tops[i] != X:
                        swapXT += 1
                    if bottoms[i] != X:
                        swapXB += 1

            # Check for value Y
            if hasY:
                if tops[i] != Y and bottoms[i] != Y:
                    hasY = False
                else:
                    if tops[i] != Y:
                        swapYT += 1
                    if bottoms[i] != Y:
                        swapYB += 1

            if not hasX and not hasY:
                return -1

        ans = (1<<32)
        if hasX:
            ans = min(ans, swapXT, swapXB)
        if hasY:
            ans = min(ans, swapYT, swapYB)
        return ans
    
        