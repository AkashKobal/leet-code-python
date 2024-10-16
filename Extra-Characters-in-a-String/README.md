# Extra Characters in a String

Can you solve this real interview question? Extra Characters in a String - You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.

Return the minimum number of extra characters left over if you break up s optimally.

 

Example 1:


Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
Output: 1
Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1.



Example 2:


Input: s = "sayhelloworld", dictionary = ["hello","world"]
Output: 3
Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters. Hence, we return 3.

## Solution
```py
class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        # Convert the dictionary list into a set for O(1) lookup time
        wordSet = set(dictionary)
        n = len(s)
        
        # dp[i] will store the minimum extra characters in the substring s[i:]
        dp = [0] * (n + 1)
        
        # Fill dp array from right to left
        for i in range(n - 1, -1, -1):
            # By default, we assume the current character is extra
            dp[i] = dp[i + 1] + 1
            
            # Try to match any word from dictionary starting at index i
            for length in range(1, n - i + 1):
                if s[i:i + length] in wordSet:
                    dp[i] = min(dp[i], dp[i + length])
        
        # The answer is the number of extra characters in the entire string
        return dp[0]
```
