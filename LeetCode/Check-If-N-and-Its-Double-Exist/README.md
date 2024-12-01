# Check If N and Its Double Exist

Can you solve this real interview question? Check If N and Its Double Exist - Given an array arr of integers, check if there exist two indices i and j such that :

 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]

 

Example 1:


Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]


Example 2:


Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.

## Solution
```py
class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        # Use a set to track visited numbers
        seen = set()
        for num in arr:
            # Check if the current number's double or half (if even) is in the set
            if 2 * num in seen or (num % 2 == 0 and num // 2 in seen):
                return True
            # Add the current number to the set
            seen.add(num)
        return False
```
