# Count Square Submatrices with All Ones

Can you solve this real interview question? Count Square Submatrices with All Ones - Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:


Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.


Example 2:


Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.

```py
class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        # Get dimensions of the matrix
        n = len(matrix)    # number of rows
        m = len(matrix[0]) # number of columns
        
        # Create a DP table with same dimensions as matrix
        dp = [[0] * m for _ in range(n)]
        
        # Variable to store total count of squares
        ans = 0
        
        # Initialize first column of DP table
        for i in range(n):
            dp[i][0] = matrix[i][0]
            ans += dp[i][0]
        
        # Initialize first row of DP table
        for j in range(1, m):
            dp[0][j] = matrix[0][j]
            ans += dp[0][j]
        
        # Fill the DP table for remaining cells
        for i in range(1, n):
            for j in range(1, m):
                # Only process if current cell in matrix is 1
                if matrix[i][j] == 1:
                    # Find minimum of left, top, and diagonal cells and add 1
                    dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1])
                ans += dp[i][j]
        
        return ans

```
