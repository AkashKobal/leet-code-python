# Maximum Absolute Sum of Any Subarray

Can you solve this real interview question? Maximum Absolute Sum of Any Subarray - You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).

Return the maximum absolute sum of any (possibly empty) subarray of nums.

Note that abs(x) is defined as follows:

 * If x is a negative integer, then abs(x) = -x.
 * If x is a non-negative integer, then abs(x) = x.

 

Example 1:


Input: nums = [1,-3,2,3,-4]
Output: 5
Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.


Example 2:


Input: nums = [2,-5,1,-4,3,-2]
Output: 8
Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.

## Solution
```py
class Solution:
    def maxAbsoluteSum(self, nums):
        n = len(nums)
        max_ending_here = nums[0]
        min_ending_here = nums[0]
        max_so_far = nums[0]
        min_so_far = nums[0]
        
        # Kadane's algorithm to find max and min subarray sums
        for i in range(1, n):
            max_ending_here = max(nums[i], max_ending_here + nums[i])
            min_ending_here = min(nums[i], min_ending_here + nums[i])
            max_so_far = max(max_so_far, max_ending_here)
            min_so_far = min(min_so_far, min_ending_here)
        
        # The maximum absolute sum is the maximum of the absolute values of max_so_far and min_so_far
        return max(abs(max_so_far), abs(min_so_far))
```
