class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n, m=len(matrix), len(matrix[0])
        col0, row0=0, 0
        for i, row in enumerate(matrix):
            for j, x in enumerate(row):
                if x==0:
                    row0|=(1<<i)
                    col0|=(1<<j)
        for i in range(n):
            if (row0>>i) &1:
                for j in range(m):
                    matrix[i][j]=0
        for j in range(m):
            if (col0>>j) &1:
                for i in range(n):
                    matrix[i][j]=0
        
        