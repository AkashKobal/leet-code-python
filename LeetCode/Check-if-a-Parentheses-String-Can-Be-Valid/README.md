# Check if a Parentheses String Can Be Valid

Can you solve this real interview question? Check if a Parentheses String Can Be Valid - A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:

 * It is ().
 * It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
 * It can be written as (A), where A is a valid parentheses string.

You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting only of '0's and '1's. For each index i of locked,

 * If locked[i] is '1', you cannot change s[i].
 * But if locked[i] is '0', you can change s[i] to either '(' or ')'.

Return true if you can make s a valid parentheses string. Otherwise, return false.

 

Example 1:

[https://assets.leetcode.com/uploads/2021/11/06/eg1.png]


Input: s = "))()))", locked = "010100"
Output: true
Explanation: locked[1] == '1' and locked[3] == '1', so we cannot change s[1] or s[3].
We change s[0] and s[4] to '(' while leaving s[2] and s[5] unchanged to make s valid.

Example 2:


Input: s = "()()", locked = "0000"
Output: true
Explanation: We do not need to make any changes because s is already valid.


Example 3:


Input: s = ")", locked = "0"
Output: false
Explanation: locked permits us to change s[0]. 
Changing s[0] to either '(' or ')' will not make s valid.

## Solution
```py
class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        n=len(s)
        if n&1==1: return False
        
        bMin, bMax=0, 0  # Initialize balance
        
        for i, c in enumerate(s):
            op=c== '('
            wild=locked[i]=='0'
            
            # Update balances
            if (not op) or wild: bMin-=1  
            else: bMin+=1  
            
            if op or wild: bMax+=1  
            else: bMax-=1  
            
            if bMax < 0: return False
            
            bMin = max(bMin, 0)
        
        # Check if the parentheses can be 
        return bMin==0

        

```
