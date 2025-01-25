# Trapping Rain Water II

Can you solve this real interview question? Trapping Rain Water II - Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.

 

Example 1:

[https://assets.leetcode.com/uploads/2021/04/08/trap1-3d.jpg]


Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small ponds 1 and 3 units trapped.
The total volume of water trapped is 4.


Example 2:

[https://assets.leetcode.com/uploads/2021/04/08/trap2-3d.jpg]


Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
Output: 10

## Solution
```py
from heapq import heappush, heappop
from typing import List

class Solution:
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        if not heightMap or not heightMap[0]:
            return 0
        
        m, n = len(heightMap), len(heightMap[0])
        visited = [[False] * n for _ in range(m)]
        heap = []
        
        # Add all boundary cells to the heap
        for i in range(m):
            for j in [0, n - 1]:
                heappush(heap, (heightMap[i][j], i, j))
                visited[i][j] = True
        
        for j in range(n):
            for i in [0, m - 1]:
                heappush(heap, (heightMap[i][j], i, j))
                visited[i][j] = True
        
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        trapped_water = 0
        while heap:
            height, x, y = heappop(heap)
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and not visited[nx][ny]:
                    trapped_water += max(0, height - heightMap[nx][ny])
                    heappush(heap, (max(height, heightMap[nx][ny]), nx, ny))
                    visited[nx][ny] = True
        
        return trapped_water
```
