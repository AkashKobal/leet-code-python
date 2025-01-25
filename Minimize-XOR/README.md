# Minimize XOR

Can you solve this real interview question? Minimize XOR - Given two positive integers num1 and num2, find the positive integer x such that:

 * x has the same number of set bits as num2, and
 * The value x XOR num1 is minimal.

Note that XOR is the bitwise XOR operation.

Return the integer x. The test cases are generated such that x is uniquely determined.

The number of set bits of an integer is the number of 1's in its binary representation.

 

Example 1:


Input: num1 = 3, num2 = 5
Output: 3
Explanation:
The binary representations of num1 and num2 are 0011 and 0101, respectively.
The integer 3 has the same number of set bits as num2, and the value 3 XOR 3 = 0 is minimal.


Example 2:


Input: num1 = 1, num2 = 12
Output: 3
Explanation:
The binary representations of num1 and num2 are 0001 and 1100, respectively.
The integer 3 has the same number of set bits as num2, and the value 3 XOR 1 = 2 is minimal.

## Solution
```py
class Solution:
    def minimizeXor(self, num1: int, num2: int) -> int:
        bitCount = bin(num2).count('1')  # Count 1-bits in num2
        bitCount -= bin(num1).count('1')  # Adjust by 1-bits in num1
        cur = 1

        while bitCount != 0:
            if bitCount < 0 and (num1 & cur) != 0:  # Remove a set bit
                num1 ^= cur
                bitCount += 1
            elif bitCount > 0 and (num1 & cur) == 0:  # Add a set bit
                num1 |= cur
                bitCount -= 1
            cur <<= 1  # Move to the next bit
        
        return num1
```
