class Solution:
    def maxAdjacentDistance(self, nums: List[int]) -> int:
        n = len(nums)

        res = 0
        for i in range(1, n+1):
            res = max(res, abs(nums[i-1]-nums[i % n]))
        return res