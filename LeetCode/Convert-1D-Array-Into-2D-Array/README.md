# Convert 1D Array Into 2D Array

Can you solve this real interview question? Convert 1D Array Into 2D Array - You are given a 0-indexed 1-dimensional (1D) integer array original, and two integers, m and n. You are tasked with creating a 2-dimensional (2D) array with m rows and n columns using all the elements from original.

The elements from indices 0 to n - 1 (inclusive) of original should form the first row of the constructed 2D array, the elements from indices n to 2 * n - 1 (inclusive) should form the second row of the constructed 2D array, and so on.

Return an m x n 2D array constructed according to the above procedure, or an empty 2D array if it is impossible.

 

Example 1:

[https://assets.leetcode.com/uploads/2021/08/26/image-20210826114243-1.png]


Input: original = [1,2,3,4], m = 2, n = 2
Output: [[1,2],[3,4]]
Explanation: The constructed 2D array should contain 2 rows and 2 columns.
The first group of n=2 elements in original, [1,2], becomes the first row in the constructed 2D array.
The second group of n=2 elements in original, [3,4], becomes the second row in the constructed 2D array.


Example 2:


Input: original = [1,2,3], m = 1, n = 3
Output: [[1,2,3]]
Explanation: The constructed 2D array should contain 1 row and 3 columns.
Put all three elements in original into the first row of the constructed 2D array.


Example 3:


Input: original = [1,2], m = 1, n = 1
Output: []
Explanation: There are 2 elements in original.
It is impossible to fit 2 elements in a 1x1 2D array, so return an empty 2D array.

```py
class Solution:
    def construct2DArray(self, original: List[int], m: int, n: int) -> List[List[int]]:
         # Check if the total elements match m * n
        if n * m != len(original):
            return []
        
        ans = []
        temp = []
        cnt = 0
        
        for val in original:
            temp.append(val)  # Add the current element to the temp row
            cnt += 1
            
            if cnt == n:  # If temp has enough elements for one row
                ans.append(temp)  # Append the row to the 2D array
                temp = []  # Reset temp for the next row
                cnt = 0  # Reset the counter

        return ans

```
