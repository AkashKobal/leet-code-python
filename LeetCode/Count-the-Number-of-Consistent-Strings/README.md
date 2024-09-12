# Count the Number of Consistent Strings

Can you solve this real interview question? Count the Number of Consistent Strings - You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.

 

Example 1:


Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.


Example 2:


Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.


Example 3:


Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
Output: 4
Explanation: Strings "cc", "acd", "ac", and "d" are consistent.

## Solution
```py
class Solution:
    def countConsistentStrings(self, allowed: str, words: list[str]) -> int:
        arr = [0] * 26
        for c in allowed:
            arr[ord(c) - ord('a')] = 1
        
        count = 0
        for word in words:
            flag = 1
            for char in word:
                if arr[ord(char) - ord('a')] == 0:
                    flag = 0
                    break
            count += flag
        return count
```
