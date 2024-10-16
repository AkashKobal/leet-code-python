# Minimum Size Subarray Sum

Can you solve this real interview question? Minimum Size Subarray Sum - Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:


Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.


Example 2:


Input: target = 4, nums = [1,4,4]
Output: 1


Example 3:


Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

## Solution
```py
class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        l = 0
        r = 0
        sum_count = nums[0]
        min_len = float('inf')
        while r <= len(nums) - 1:
            if sum_count < target:
                r += 1
                if r <= len(nums) - 1:
                    sum_count += nums[r]
            else:
                min_len = min(min_len, r-l + 1)
                sum_count -= nums[l]
                l += 1
        if min_len == float('inf'):
            return 0
        return min_len



```
