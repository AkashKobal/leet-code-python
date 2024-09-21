# Lexicographical Numbers

Can you solve this real interview question? Lexicographical Numbers - Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

 

Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]


Example 2:

Input: n = 2
Output: [1,2]

## Solution
```py
class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        result = []
        current = 1

        for _ in range(n):
            result.append(current)
            current = self.get_next_number(current, n)

        return result

    def get_next_number(self, current: int, n: int) -> int:
        if current * 10 <= n:
            return current * 10  # Move to the next "level" in the lexicographical order

        if current >= n:
            current //= 10  # Go back to the parent node

        current += 1  # Increment to get to the next number
        
        while current % 10 == 0:
            current //= 10  # Remove trailing zeros

        return current
```
