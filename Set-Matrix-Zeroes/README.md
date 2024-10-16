# Set Matrix Zeroes

Can you solve this real interview question? Set Matrix Zeroes - Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place [https://en.wikipedia.org/wiki/In-place_algorithm].

 

Example 1:

[https://assets.leetcode.com/uploads/2020/08/17/mat1.jpg]


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]


Example 2:

[https://assets.leetcode.com/uploads/2020/08/17/mat2.jpg]


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

## Solution
```py
class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        # Step 1: Handle edge case for an empty matrix
        if not matrix:
            return
        
        # Step 2: Get the dimensions of the matrix
        rows, cols = len(matrix), len(matrix[0])
        
        # Step 3: Create a deep copy of the original matrix
        copy_matrix = [row[:] for row in matrix]
        
        # Step 4: Traverse the original matrix to find zeros
        for row in range(rows):
            for col in range(cols):
                if matrix[row][col] == 0:
                    # Step 5: Mark the entire row with zeros in the copied matrix
                    for k in range(cols):
                        copy_matrix[row][k] = 0
                    # Step 6: Mark the entire column with zeros in the copied matrix
                    for k in range(rows):
                        copy_matrix[k][col] = 0
        
        # Step 7: Copy the updated values back to the original matrix
        for row in range(rows):
            for col in range(cols):
                matrix[row][col] = copy_matrix[row][col]

        # Why deep copy?
        # Using a deep copy prevents discrepancies that could occur
        # if we modified the original matrix during iteration.
```
