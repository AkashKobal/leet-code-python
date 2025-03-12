# Maximum Count of Positive Integer and Negative Integer

Can you solve this real interview question? Maximum Count of Positive Integer and Negative Integer - Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.

 * In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.

Note that 0 is neither positive nor negative.

 

Example 1:


Input: nums = [-2,-1,-1,1,2,3]
Output: 3
Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.


Example 2:


Input: nums = [-3,-2,-1,0,0,1,2]
Output: 3
Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.


Example 3:


Input: nums = [5,20,66,1314]
Output: 4
Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.

## Solution
```py
class Solution:
    def maximumCount(self, nums):
        n = len(nums)
        left, right = 0, n - 1

        # Find the index of the first positive number
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] > 0:
                right = mid - 1
            else:
                left = mid + 1
        # Now, 'left' is the index of the first positive number
        positive_count = n - left

        # Find the last negative number using binary search
        left, right = 0, n - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] < 0:
                left = mid + 1  # Move right
            else:
                right = mid - 1  # Move left
        # Now, 'right' is the index of the last negative number
        negative_count = right + 1

        # Return the maximum count of positive and negative integers
        return max(positive_count, negative_count)
```
