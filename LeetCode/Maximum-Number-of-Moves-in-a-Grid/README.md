# Maximum Number of Moves in a Grid

Can you solve this real interview question? Maximum Number of Moves in a Grid - You are given a 0-indexed m x n matrix grid consisting of positive integers.

You can start at any cell in the first column of the matrix, and traverse the grid in the following way:

 * From a cell (row, col), you can move to any of the cells: (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1) such that the value of the cell you move to, should be strictly bigger than the value of the current cell.

Return the maximum number of moves that you can perform.

 

Example 1:

[https://assets.leetcode.com/uploads/2023/04/11/yetgriddrawio-10.png]


Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
Output: 3
Explanation: We can start at the cell (0, 0) and make the following moves:
- (0, 0) -> (0, 1).
- (0, 1) -> (1, 2).
- (1, 2) -> (2, 3).
It can be shown that it is the maximum number of moves that can be made.

Example 2:


[https://assets.leetcode.com/uploads/2023/04/12/yetgrid4drawio.png]
Input: grid = [[3,2,4],[2,1,9],[1,1,7]]
Output: 0
Explanation: Starting from any cell in the first column we cannot perform any moves.

## Solution
```py
class Solution:
    def maxMoves(self, grid: List[List[int]]) -> int:
        # Get dimensions of the grid
        m = len(grid)    # number of rows
        n = len(grid[0]) # number of columns
        
        # res will store the rightmost column we can reach
        res = 0
        
        # dp array stores the maximum number of moves possible to reach each cell
        # in the current column we're processing
        dp = [0] * m
        
        # Iterate through each column from left to right (starting from column 1)
        for j in range(1, n):
            # leftTop keeps track of the dp value from the cell above-left
            leftTop = 0
            # found indicates if we can reach any cell in current column
            found = False
            
            # Iterate through each row in current column
            for i in range(m):
                # cur will store the maximum moves to reach current cell
                cur = -1
                # Store dp[i] for next iteration's leftTop
                nxtLeftTop = dp[i]
                
                # Check move from top-left cell (if valid)
                if i - 1 >= 0 and leftTop != -1 and grid[i][j] > grid[i-1][j-1]:
                    cur = max(cur, leftTop + 1)
                
                # Check move from direct left cell (if valid)
                if dp[i] != -1 and grid[i][j] > grid[i][j-1]:
                    cur = max(cur, dp[i] + 1)
                
                # Check move from bottom-left cell (if valid)
                if i + 1 < m and dp[i+1] != -1 and grid[i][j] > grid[i+1][j-1]:
                    cur = max(cur, dp[i+1] + 1)
                
                # Update dp array for current cell
                dp[i] = cur
                # Update found flag if we can reach current cell
                found = found or (dp[i] != -1)
                # Update leftTop for next row's iteration
                leftTop = nxtLeftTop
            
            # If we can't reach any cell in current column, break
            if not found:
                break
            # Update result to current column if we can reach it
            res = j
        
        # Return the maximum number of moves possible
        return res
```
