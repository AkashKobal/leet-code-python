class Solution:
    def minimumLength(self, s: str) -> int:
        return sum(2-(f&1) for f in Counter(s).values())
        