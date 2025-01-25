# Target Sum

Can you solve this real interview question? Target Sum - You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".

Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:


Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3


Example 2:


Input: nums = [1], target = 1
Output: 1

## Solution
```py
class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        # Calculate the total sum of nums
        total_sum = sum(nums)

        # Edge case: if target is out of bounds of achievable sums
        if target > total_sum or (total_sum - target) % 2 != 0:
            return 0

        # The actual sum we need to find in subset (derived from equation)
        s = (total_sum - target) // 2

        # Initialize the DP table where dp[j] is the number of ways to sum to j
        dp = [0] * (s + 1)
        dp[0] = 1  # There's one way to get sum 0, by choosing nothing

        # Update dp table for each number in nums
        for num in nums:
            for j in range(s, num - 1, -1):  # Traverse backward to avoid overwriting
                dp[j] += dp[j - num]

        return dp[s]
```
