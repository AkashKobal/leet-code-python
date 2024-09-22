# Game of Life

Can you solve this real interview question? Game of Life - According to Wikipedia's article [https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life]: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors [https://en.wikipedia.org/wiki/Moore_neighborhood] (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

 1. Any live cell with fewer than two live neighbors dies as if caused by under-population.
 2. Any live cell with two or three live neighbors lives on to the next generation.
 3. Any live cell with more than three live neighbors dies, as if by over-population.
 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

 

Example 1:

![](https://assets.leetcode.com/uploads/2020/12/26/grid1.jpg)


Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]


Example 2:

![](https://assets.leetcode.com/uploads/2020/12/26/grid2.jpg)


Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]

## Solution
```py
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rowLen=len(board[0])
        colLen=len(board)
        ans = [[-1 for x in range(rowLen)] for y in range(colLen)]

        def inBound(i,j):
            return (0<=i<colLen) and (0<=j<rowLen)

        for i in range(colLen):
            for j in range(rowLen):
                count=0
                for ii,jj in [(i,j+1),(i,j-1),(i-1,j),(i+1,j),(i-1,j+1),(i+1,j-1),(i+1,j+1),(i-1,j-1)]:
                    if inBound(ii,jj):
                        count+=board[ii][jj]
                if count<2:
                    ans[i][j]=0
                elif board[i][j]==1 and (count==2 or count==3):
                    ans[i][j]=1
                elif board[i][j]==1 and count>3:
                    ans[i][j]=0
                elif board[i][j]==0 and count==3:
                    ans[i][j]=1
                else:
                    ans[i][j]=board[i][j]

        board[:]=ans
        return board
```
