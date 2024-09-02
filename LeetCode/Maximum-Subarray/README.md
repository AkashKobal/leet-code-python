# Maximum Subarray

Can you solve this real interview question? Maximum Subarray - Given an integer array nums, find the subarray with the largest sum, and return its sum.

 

Example 1:


Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.


Example 2:


Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.


Example 3:


Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


```py
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        curr_sum = nums[0] # initializing first element to curr_sum
        max_sum = nums[0] # initializing max_sum to first element
        for i in range(1,len(nums)):
            curr_sum = max(curr_sum + nums[i], nums[i]) # formula
            max_sum = max(curr_sum,max_sum)

        return max_sum
```
