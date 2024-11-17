# Count the Number of Fair Pairs

Can you solve this real interview question? Count the Number of Fair Pairs - Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.

A pair (i, j) is fair if:

 * 0 <= i < j < n, and
 * lower <= nums[i] + nums[j] <= upper

 

Example 1:


Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
Output: 6
Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).


Example 2:


Input: nums = [1,7,9,2,5], lower = 11, upper = 11
Output: 1
Explanation: There is a single fair pair: (2,3).

## Soultion
```py
class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        # Step 1: Sort the array
        nums.sort()
        
        n = len(nums)
        count = 0
        
        # Step 2: For each element nums[i], use binary search to find the valid range for nums[j]
        for i in range(n - 1):
            # Determine the range of values that nums[j] could be
            min_val = lower - nums[i]
            max_val = upper - nums[i]
            
            # Use binary search to find the range [start, end] in the sorted array
            start = bisect.bisect_left(nums, min_val, i + 1, n)
            end = bisect.bisect_right(nums, max_val, i + 1, n) - 1
            
            # The number of valid pairs for this i is end - start + 1
            if start <= end:
                count += end - start + 1
        
        return count
```
