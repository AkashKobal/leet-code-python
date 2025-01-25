# Counting Words With a Given Prefix

Can you solve this real interview question? Counting Words With a Given Prefix - You are given an array of strings words and a string pref.

Return the number of strings in words that contain pref as a prefix.

A prefix of a string s is any leading contiguous substring of s.

 

Example 1:


Input: words = ["pay","attention","practice","attend"], pref = "at"
Output: 2
Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".


Example 2:


Input: words = ["leetcode","win","loops","success"], pref = "code"
Output: 0
Explanation: There are no strings that contain "code" as a prefix.

## Solution
```py
class Solution:
    def prefixCount(self, words: list[str], pref: str) -> int:
        c = 0
        n = len(pref)
        for word in words:
            if len(word) >= n and word[:n] == pref:
                c += 1
        return c
```
