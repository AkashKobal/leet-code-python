# Spiral Matrix

Can you solve this real interview question? Spiral Matrix - Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:

[https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg]


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]


Example 2:

[https://assets.leetcode.com/uploads/2020/11/13/spiral.jpg]


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

## Solution
```py
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        rows, cols = len(matrix), len(matrix[0])
        x, y, dx, dy = 0, 0, 1, 0
        res = []

        for _ in range(rows * cols):
            res.append(matrix[y][x])
            matrix[y][x] = "."

            if not 0 <= x + dx < cols or not 0 <= y + dy < rows or matrix[y+dy][x+dx] == ".":
                dx, dy = -dy, dx
            
            x += dx
            y += dy
        
        return res
```
