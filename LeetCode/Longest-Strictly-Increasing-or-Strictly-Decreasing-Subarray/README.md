# Longest Strictly Increasing or Strictly Decreasing Subarray

Can you solve this real interview question? Longest Strictly Increasing or Strictly Decreasing Subarray - You are given an array of integers nums. Return the length of the longest subarray of nums which is either strictly increasing or strictly decreasing.

 

Example 1:

Input: nums = [1,4,3,3,2]

Output: 2

Explanation:

The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].

The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].

Hence, we return 2.

Example 2:

Input: nums = [3,3,3,3]

Output: 1

Explanation:

The strictly increasing subarrays of nums are [3], [3], [3], and [3].

The strictly decreasing subarrays of nums are [3], [3], [3], and [3].

Hence, we return 1.

Example 3:

Input: nums = [3,2,1]

Output: 3

Explanation:

The strictly increasing subarrays of nums are [3], [2], and [1].

The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1], and [3,2,1].

Hence, we return 3.

## Solution
```py
class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        n, ans, inc, dec=len(nums), 0, 1, 1
        if n==1: return 1
        for i in range(1, n):
            if nums[i]>nums[i-1]:
                inc+=1
                dec=1
            elif nums[i]<nums[i-1]:
                inc=1
                dec+=1
            else:
                inc=dec=1
            ans=max(ans, dec, inc)
        return ans

```
