# Count Unguarded Cells in the Grid

Can you solve this real interview question? Count Unguarded Cells in the Grid - You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.

A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.

Return the number of unoccupied cells that are not guarded.

 

Example 1:

[https://assets.leetcode.com/uploads/2022/03/10/example1drawio2.png]


Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
Output: 7
Explanation: The guarded and unguarded cells are shown in red and green respectively in the above diagram.
There are a total of 7 unguarded cells, so we return 7.


Example 2:

[https://assets.leetcode.com/uploads/2022/03/10/example2drawio.png]


Input: m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
Output: 4
Explanation: The unguarded cells are shown in green in the above diagram.
There are a total of 4 unguarded cells, so we return 4.

## Solution
```py
class Solution:
    def countUnguarded(self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]) -> int:
        # Initialize grid: 0 = unoccupied, 1 = wall/guard, 2 = guarded
        grid = [[0] * n for _ in range(m)]
        
        # Place guards and walls in the grid
        for r, c in guards:
            grid[r][c] = 1  # Guard
        for r, c in walls:
            grid[r][c] = 1  # Wall
        
        # Directions for cardinal movement: up, down, left, right
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        
        # Mark cells guarded by the guards
        for r, c in guards:
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                while 0 <= nr < m and 0 <= nc < n:
                    if grid[nr][nc] == 1:  # Stop at a wall or another guard
                        break
                    if grid[nr][nc] == 0:  # Mark as guarded
                        grid[nr][nc] = 2
                    nr += dr
                    nc += dc
        
        # Count unoccupied and unguarded cells
        unguarded_count = sum(1 for r in range(m) for c in range(n) if grid[r][c] == 0)
        
        return unguarded_count
```