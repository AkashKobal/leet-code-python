# Make Sum Divisible by P

Can you solve this real interview question? Make Sum Divisible by P - Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.

Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.

A subarray is defined as a contiguous block of elements in the array.

 

Example 1:


Input: nums = [3,1,4,2], p = 6
Output: 1
Explanation: The sum of the elements in nums is 10, which is not divisible by 6. We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.


Example 2:


Input: nums = [6,3,5,2], p = 9
Output: 2
Explanation: We cannot remove a single element to get a sum divisible by 9. The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.


Example 3:


Input: nums = [1,2,3], p = 3
Output: 0
Explanation: Here the sum is 6. which is already divisible by 3. Thus we do not need to remove anything.

## Solution
```py
class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        # Step 1: Calculate total sum and the remainder that needs to be removed
        total_sum = sum(nums)
        target_remainder = total_sum % p
        
        # If the total sum is already divisible by p, no need to remove anything
        if target_remainder == 0:
            return 0
        
        # Step 2: Initialize variables
        prefix_sum = 0
        min_length = len(nums)
        remainder_map = {0: -1}  # This is used to store the mod value of prefix sums
        
        # Step 3: Traverse the array
        for i, num in enumerate(nums):
            prefix_sum = (prefix_sum + num) % p
            # Calculate the mod of the required prefix sum to find the subarray
            needed_remainder = (prefix_sum - target_remainder) % p
            
            if needed_remainder in remainder_map:
                min_length = min(min_length, i - remainder_map[needed_remainder])
            
            # Update the map with the current prefix_sum mod p and index
            remainder_map[prefix_sum] = i
        
        # Step 4: If no valid subarray was found, return -1
        return min_length if min_length < len(nums) else -1
```
