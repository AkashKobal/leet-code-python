# Is Subsequence

Can you solve this real interview question? Is Subsequence - Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true


Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false

## Solution
```py
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        i, j = 0, 0  # Initialize pointers for s and t
        while i < len(s) and j < len(t):
            if s[i] == t[j]:  # Check if current characters match
                i += 1  # Move pointer in s
            j += 1  # Always move pointer in t
        
        # Check if all characters in s were found in t
        return i == len(s)
```
