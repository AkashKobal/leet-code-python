class Solution:
    def countPartitions(self, nums: List[int]) -> int:
        par = nums.pop() & 1
        for c in nums:
            par ^= (c & 1)
        return len(nums) * (par ^ 1)
