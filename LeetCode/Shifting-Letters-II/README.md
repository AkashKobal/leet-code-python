# Shifting Letters II

Can you solve this real interview question? Shifting Letters II - You are given a string s of lowercase English letters and a 2D integer array shifts where shifts[i] = [starti, endi, directioni]. For every i, shift the characters in s from the index starti to the index endi (inclusive) forward if directioni = 1, or shift the characters backward if directioni = 0.

Shifting a character forward means replacing it with the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). Similarly, shifting a character backward means replacing it with the previous letter in the alphabet (wrapping around so that 'a' becomes 'z').

Return the final string after all such shifts to s are applied.

 

Example 1:


Input: s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
Output: "ace"
Explanation: Firstly, shift the characters from index 0 to index 1 backward. Now s = "zac".
Secondly, shift the characters from index 1 to index 2 forward. Now s = "zbd".
Finally, shift the characters from index 0 to index 2 forward. Now s = "ace".

Example 2:


Input: s = "dztz", shifts = [[0,0,0],[1,1,1]]
Output: "catz"
Explanation: Firstly, shift the characters from index 0 to index 0 backward. Now s = "cztz".
Finally, shift the characters from index 1 to index 1 forward. Now s = "catz".

## Solution
```py
from typing import List

class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        n = len(s)
        checked = [0] * (n + 1)  # Difference array for range updates
        for start, end, direction in shifts:
            checked[start] += 2 * direction - 1  # +1 for right, -1 for left
            checked[end + 1] -= 2 * direction - 1  # Reverse the shift after end+1
        shared = 0
        s = list(s)  # Convert to list for mutability
        for i in range(n):
            shared += checked[i]  # Compute cumulative shifts
            s[i] = chr(((ord(s[i]) - 97 + shared) % 26) + 97)  # Apply shift with wrap-around
        return ''.join(s)  # Return final string
```
