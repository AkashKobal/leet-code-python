# Shortest Subarray With OR at Least K II

Can you solve this real interview question? Shortest Subarray With OR at Least K II - You are given an array nums of non-negative integers and an integer k.

An array is called special if the bitwise OR of all of its elements is at least k.

Return the length of the shortest special non-empty subarray of nums, or return -1 if no special subarray exists.

 

Example 1:

Input: nums = [1,2,3], k = 2

Output: 1

Explanation:

The subarray [3] has OR value of 3. Hence, we return 1.

Example 2:

Input: nums = [2,1,8], k = 10

Output: 3

Explanation:

The subarray [2,1,8] has OR value of 11. Hence, we return 3.

Example 3:

Input: nums = [1,2], k = 0

Output: 1

Explanation:

The subarray [1] has OR value of 1. Hence, we return 1.

## Solution
```py
class Solution:
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        if k == 0:
            return 1
        
        ans = len(nums) + 1
        bits = [0] * 32
        left = 0
        n = len(nums)

        for right in range(n):
            temp = 0
            for i in range(32):
                if nums[right] & (1 << i):
                    bits[i] += 1
                if bits[i] > 0:
                    temp |= (1 << i)
            
            if temp >= k:
                ans = min(ans, right - left + 1)
            
            while temp >= k:  # Constraints not satisfying, so move the left pointer
                temp = 0
                for i in range(32):
                    if nums[left] & (1 << i):
                        bits[i] -= 1
                    if bits[i] > 0:
                        temp |= (1 << i)
                
                left += 1
                if temp >= k:
                    ans = min(ans, right - left + 1)

        return -1 if ans == (len(nums) + 1) else ans
```
