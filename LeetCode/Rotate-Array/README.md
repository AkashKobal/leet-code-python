# Rotate Array

Can you solve this real interview question? Rotate Array - Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:


Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]


Example 2:


Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

## Solution
```py
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        
        size = len(nums)
        k = k % len(nums)
        start = 0
        last = 0
        currIdx = 0
        for round in range(k):
            while currIdx < size:
                tmp = nums[currIdx]
                nums[currIdx] = last
                last = tmp
                currIdx += k
            
            currIdx = currIdx - size
            if currIdx == start:
                nums[currIdx] = last
                currIdx += 1
                start = currIdx

        return nums     


```
