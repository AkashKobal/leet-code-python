# Shortest Palindrome

Can you solve this real interview question? Shortest Palindrome - You are given a string s. You can convert s to a palindrome by adding characters in front of it.

Return the shortest palindrome you can find by performing this transformation.

 

Example 1:

Input: s = "aacecaaa"
Output: "aaacecaaa"


Example 2:

Input: s = "abcd"
Output: "dcbabcd"

## Solution
```py
class Solution:
    def shortestPalindrome(self, s: str) -> str:
        i, n=0, len(s)
        for c in s[::-1]:
            if c==s[i]:i+=1
        if i==n: return s
        sub=s[i:]
        return sub[::-1]+self.shortestPalindrome(s[0:i])+sub
```
