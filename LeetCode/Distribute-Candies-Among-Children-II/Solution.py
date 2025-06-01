class Solution:
    def distributeCandies(self, n: int, limit: int) -> int:
        def H3(n):
            return 0 if n<0 else (n+2)*(n+1)//2
        return H3(n)-3*H3(n-limit-1)+3*H3(n-2*(limit+1))-H3(n-3*(limit+1))
        