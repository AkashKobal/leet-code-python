# Map of Highest Peak

Can you solve this real interview question? Map of Highest Peak - You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

 * If isWater[i][j] == 0, cell (i, j) is a land cell.
 * If isWater[i][j] == 1, cell (i, j) is a water cell.

You must assign each cell a height in a way that follows these rules:

 * The height of each cell must be non-negative.
 * If the cell is a water cell, its height must be 0.
 * Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).

Find an assignment of heights such that the maximum height in the matrix is maximized.

Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.

 

Example 1:

[https://assets.leetcode.com/uploads/2021/01/10/screenshot-2021-01-11-at-82045-am.png]


Input: isWater = [[0,1],[0,0]]
Output: [[1,0],[2,1]]
Explanation: The image shows the assigned heights of each cell.
The blue cell is the water cell, and the green cells are the land cells.


Example 2:

[https://assets.leetcode.com/uploads/2021/01/10/screenshot-2021-01-11-at-82050-am.png]


Input: isWater = [[0,0,1],[1,0,0],[0,0,0]]
Output: [[1,1,0],[0,1,1],[1,2,2]]
Explanation: A height of 2 is the maximum possible height of any assignment.
Any height assignment that has a maximum height of 2 while still meeting the rules will also be accepted.

## Solution
```py
class Solution:
    def highestPeak(self, isWater: List[List[int]]) -> List[List[int]]:
        R = len(isWater)
        C = len(isWater[0])
        height = [[float('inf')] * C for _ in range(R)]

        for i in range(R):
            for j in range(C):
                if isWater[i][j] == 1:
                    height[i][j] = 0
                else:
                    if i > 0:
                        height[i][j] = min(height[i][j], height[i - 1][j] + 1)
                    if j > 0:
                        height[i][j] = min(height[i][j], height[i][j - 1] + 1)

        for i in range(R - 1, -1, -1):
            for j in range(C - 1, -1, -1):
                if i < R - 1:
                    height[i][j] = min(height[i][j], height[i + 1][j] + 1)
                if j < C - 1:
                    height[i][j] = min(height[i][j], height[i][j + 1] + 1)

        return height
```
