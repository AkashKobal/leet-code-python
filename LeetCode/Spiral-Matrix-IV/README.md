# Spiral Matrix IV

Can you solve this real interview question? Spiral Matrix IV - You are given two integers m and n, which represent the dimensions of a matrix.

You are also given the head of a linked list of integers.

Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise), starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.

Return the generated matrix.

 

Example 1:

[https://assets.leetcode.com/uploads/2022/05/09/ex1new.jpg]


Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
Explanation: The diagram above shows how the values are printed in the matrix.
Note that the remaining spaces in the matrix are filled with -1. 


Example 2:

[https://assets.leetcode.com/uploads/2022/05/11/ex2.jpg]


Input: m = 1, n = 4, head = [0,1,2]
Output: [[0,1,2,-1]]
Explanation: The diagram above shows how the values are printed from left to right in the matrix.
The last space in the matrix is set to -1.

## Solution
```py
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def spiralMatrix(self, m: int, n: int, head: Optional[ListNode]) -> List[List[int]]:
        mat = [[-1 for _ in range(n)] for _ in range(m)]
        array = []
        while head:
            array.append(head.val)
            head = head.next
        size = len(array)
        t,b,l,r = 0,m-1,0,n-1
        idx = 0

        while t <= b and l <= r and idx < size:
            for i in range(l,r+1):
                if idx < size:
                    mat[t][i] = array[idx]
                    idx += 1
            t += 1
            for i in range(t,b+1):
                if idx < size:
                    mat[i][r] = array[idx]
                    idx += 1
            r -= 1
            if t <= b:
                for i in range(r,l-1,-1):
                    if idx < size:
                        mat[b][i] = array[idx]
                        idx += 1
                b -= 1
            if l <= r:
                for i in range(b,t-1,-1):
                    if idx < size:
                        mat[i][l] = array[idx]
                        idx += 1
                l += 1

        return mat
```
