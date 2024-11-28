# Minimum Obstacle Removal to Reach Corner

Can you solve this real interview question? Minimum Obstacle Removal to Reach Corner - You are given a 0-indexed 2D integer array grid of size m x n. Each cell has one of two values:

 * 0 represents an empty cell,
 * 1 represents an obstacle that may be removed.

You can move up, down, left, or right from and to an empty cell.

Return the minimum number of obstacles to remove so you can move from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1).

 

Example 1:

[https://assets.leetcode.com/uploads/2022/04/06/example1drawio-1.png]


Input: grid = [[0,1,1],[1,1,0],[1,1,0]]
Output: 2
Explanation: We can remove the obstacles at (0, 1) and (0, 2) to create a path from (0, 0) to (2, 2).
It can be shown that we need to remove at least 2 obstacles, so we return 2.
Note that there may be other ways to remove 2 obstacles to create a path.


Example 2:

[https://assets.leetcode.com/uploads/2022/04/06/example1drawio.png]


Input: grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]
Output: 0
Explanation: We can move from (0, 0) to (2, 4) without removing any obstacles, so we return 0.

## Solution
```py
class Solution:
    def minimumObstacles(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        distance = [[float('inf')] * n for _ in range(m)]
        dq = collections.deque()

        distance[0][0] = 0
        dq.appendleft((0, 0))
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        while dq:
            x, y = dq.popleft()
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n:
                    newDist = distance[x][y] + grid[nx][ny]
                    if newDist < distance[nx][ny]:
                        distance[nx][ny] = newDist
                        if grid[nx][ny] == 0:
                            dq.appendleft((nx, ny))
                        else:
                            dq.append((nx, ny))
        return distance[m-1][n-1]
```
