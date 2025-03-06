# Find Missing and Repeated Values

Can you solve this real interview question? Find Missing and Repeated Values - You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.

Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

 

Example 1:


Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].


Example 2:


Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
Output: [9,5]
Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].

## Solution
```py
class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        n: int = len(grid)
        size: int = n * n
        freq: List[int] = [0] * (size + 1)
        repeated: int = -1
        missing: int = -1

        for row in grid:
            for num in row:
                freq[num] += 1

        for num in range(1, size + 1):
            if freq[num] == 2:
                repeated = num
            if freq[num] == 0:
                missing = num

        return [repeated, missing]
```
