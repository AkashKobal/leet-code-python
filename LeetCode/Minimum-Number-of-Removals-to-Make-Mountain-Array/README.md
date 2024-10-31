# Minimum Number of Removals to Make Mountain Array

Can you solve this real interview question? Minimum Number of Removals to Make Mountain Array - You may recall that an array arr is a mountain array if and only if:

 * arr.length >= 3
 * There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
   * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
   * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Given an integer array nums , return the minimum number of elements to remove to make nums a mountain array.

 

Example 1:


Input: nums = [1,3,1]
Output: 0
Explanation: The array itself is a mountain array so we do not need to remove any elements.


Example 2:


Input: nums = [2,1,1,5,6,2,3,1]
Output: 3
Explanation: One solution is to remove the elements at indices 0, 1, and 5, making the array nums = [1,5,6,3,1].

## Solution
```py
class Solution:
    def minimumMountainRemovals(self, nums: List[int]) -> int:
        n = len(nums)
        LIS = [1] * n
        LDS = [1] * n

        # Compute LIS for each index
        for i in range(n):
            for j in range(i):
                if nums[i] > nums[j]:
                    LIS[i] = max(LIS[i], LIS[j] + 1)

        # Compute LDS from each index
        for i in range(n - 1, -1, -1):
            for j in range(n - 1, i, -1):
                if nums[i] > nums[j]:
                    LDS[i] = max(LDS[i], LDS[j] + 1)

        maxMountainLength = 0

        # Find the maximum mountain length
        for i in range(1, n - 1):
            if LIS[i] > 1 and LDS[i] > 1:  # Valid peak
                maxMountainLength = max(maxMountainLength, LIS[i] + LDS[i] - 1)

        return n - maxMountainLength
```
