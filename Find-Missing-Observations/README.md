# Find Missing Observations

Can you solve this real interview question? Find Missing Observations - You have observations of n + m 6-sided dice rolls with each face numbered from 1 to 6. n of the observations went missing, and you only have the observations of m rolls. Fortunately, you have also calculated the average value of the n + m rolls.

You are given an integer array rolls of length m where rolls[i] is the value of the ith observation. You are also given the two integers mean and n.

Return an array of length n containing the missing observations such that the average value of the n + m rolls is exactly mean. If there are multiple valid answers, return any of them. If no such array exists, return an empty array.

The average value of a set of k numbers is the sum of the numbers divided by k.

Note that mean is an integer, so the sum of the n + m rolls should be divisible by n + m.

 

Example 1:


Input: rolls = [3,2,4,3], mean = 4, n = 2
Output: [6,6]
Explanation: The mean of all n + m rolls is (3 + 2 + 4 + 3 + 6 + 6) / 6 = 4.


Example 2:


Input: rolls = [1,5,6], mean = 3, n = 4
Output: [2,3,2,2]
Explanation: The mean of all n + m rolls is (1 + 5 + 6 + 2 + 3 + 2 + 2) / 7 = 3.


Example 3:


Input: rolls = [1,2,3,4], mean = 6, n = 4
Output: []
Explanation: It is impossible for the mean to be 6 no matter what the 4 missing rolls are.

```py
class Solution:
    def missingRolls(self, rolls: List[int], mean: int, n: int) -> List[int]:
        # m is the number of observed rolls
        m = len(rolls)
        
        # Calculate the sum of the observed rolls
        cur_sum = sum(rolls)
        
        # Step 1: Calculate the total sum required for all n + m rolls to have the given mean
        # required_sum is the sum that the n + m rolls should add up to
        required_sum = (n + m) * mean

        # Step 2: Calculate the sum that the missing n rolls should add up to
        # missing_sum is the difference between required_sum and cur_sum
        missing_sum = required_sum - cur_sum

        # Step 3: Check if it is possible to generate n missing rolls that sum to missing_sum
        # Each missing roll must be between 1 and 6, so the sum of n rolls must be between n and n*6
        if missing_sum < n or missing_sum > n * 6:
            return []  # If the missing_sum is not achievable, return an empty list

        # Step 4: Initialize an array of size n with all elements set to 1 (minimum value for each roll)
        ans = [1] * n

        # Subtract n from missing_sum since we initialized each roll with 1
        missing_sum -= n

        # Step 5: Distribute the remaining missing_sum across the n rolls
        for i in range(n):
            # Add as much as possible (at most 5, since each roll can be at most 6)
            ans[i] += min(5, missing_sum)

            # Decrease the remaining missing_sum by the amount added to ans[i]
            missing_sum -= 5

            # If missing_sum is now zero, break out of the loop as no more distribution is needed
            if missing_sum <= 0:
                break

        # Return the constructed array of missing rolls
        return ans
        
```
