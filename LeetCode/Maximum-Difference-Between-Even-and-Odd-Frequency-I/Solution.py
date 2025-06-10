class Solution:
    def maxDifference(self, s: str) -> int:
        from collections import Counter
        
        freq = Counter(s)
        odd = 0
        even = len(s)

        for count in freq.values():
            if count % 2 == 1:
                odd = max(odd, count)
            elif count != 0:
                even = min(even, count)

        return odd - even