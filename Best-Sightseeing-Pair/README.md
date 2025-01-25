# Best Sightseeing Pair

Can you solve this real interview question? Best Sightseeing Pair - You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.

The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.

 

Example 1:


Input: values = [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11


Example 2:


Input: values = [1,2]
Output: 2

## Solution
```py
class Solution:
    def maxScoreSightseeingPair(self, values: List[int]) -> int:
        n = len(values)
        suffixMax = [0] * n
        suffixMax[n - 1] = values[n - 1] - (n - 1)

        for i in range(n - 2, -1, -1):
            suffixMax[i] = max(suffixMax[i + 1], values[i] - i)

        maxScore = float('-inf')

        for i in range(n - 1):
            maxScore = max(maxScore, values[i] + i + suffixMax[i + 1])

        return maxScore
```
