# Flip Columns For Maximum Number of Equal Rows

Can you solve this real interview question? Flip Columns For Maximum Number of Equal Rows - You are given an m x n binary matrix matrix.

You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from 0 to 1 or vice versa).

Return the maximum number of rows that have all values equal after some number of flips.

 

Example 1:


Input: matrix = [[0,1],[1,1]]
Output: 1
Explanation: After flipping no values, 1 row has all values equal.


Example 2:


Input: matrix = [[0,1],[1,0]]
Output: 2
Explanation: After flipping values in the first column, both rows have equal values.


Example 3:


Input: matrix = [[0,0,0],[0,0,1],[1,1,0]]
Output: 2
Explanation: After flipping values in the first two columns, the last two rows have equal values.

## Solituin
```py
class Solution:
    def maxEqualRowsAfterFlips(self, matrix: List[List[int]]) -> int:
        pattern_count = {}
        
        for row in matrix:
            # Normalize the row pattern
            # If the first element is 0, keep the row as is
            # If the first element is 1, take the complement of the row
            normalized = tuple(cell if row[0] == 0 else 1 - cell for cell in row)
            
            # Count the occurrences of each normalized pattern
            if normalized not in pattern_count:
                pattern_count[normalized] = 0
            pattern_count[normalized] += 1
        
        # The maximum value in pattern_count is the answer
        return max(pattern_count.values())
```
