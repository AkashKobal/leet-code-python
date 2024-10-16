# Longest Substring Without Repeating Characters

Can you solve this real interview question? Longest Substring Without Repeating Characters - Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:


Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.


Example 2:


Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.


Example 3:


Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

## Solution
```py
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = set()
        count = 0
        l = 0
        for r in range(len(s)):
            while s[r] in res:
                res.remove(s[l])
                l+=1
            res.add(s[r])
            count = max(count,r-l+1)
        return count
```
