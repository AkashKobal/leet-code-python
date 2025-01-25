# Count Ways To Build Good Strings

Can you solve this real interview question? Count Ways To Build Good Strings - Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at each step perform either of the following:

 * Append the character '0' zero times.
 * Append the character '1' one times.

This can be performed any number of times.

A good string is a string constructed by the above process having a length between low and high (inclusive).

Return the number of different good strings that can be constructed satisfying these properties. Since the answer can be large, return it modulo 109 + 7.

 

Example 1:


Input: low = 3, high = 3, zero = 1, one = 1
Output: 8
Explanation: 
One possible valid good string is "011". 
It can be constructed as follows: "" -> "0" -> "01" -> "011". 
All binary strings from "000" to "111" are good strings in this example.


Example 2:


Input: low = 2, high = 3, zero = 1, one = 2
Output: 5
Explanation: The good strings are "00", "11", "000", "110", and "011".

## Solution
```py
class Solution:
    def countGoodStrings(self, low: int, high: int, zero: int, one: int) -> int:
        MOD = 10**9 + 7

        # dp[i] will store the number of good strings of length i
        dp = [0] * (high + 1)

        # Base case: There's 1 way to make an empty string
        dp[0] = 1

        # Iterate over all lengths from 1 to high
        for length in range(1, high + 1):
            # If we append '0' zero times, we reduce the length by `zero`
            if length >= zero:
                dp[length] = (dp[length] + dp[length - zero]) % MOD

            # If we append '1' one times, we reduce the length by `one`
            if length >= one:
                dp[length] = (dp[length] + dp[length - one]) % MOD

        # Sum up all dp[i] for lengths in the range [low, high]
        return sum(dp[low:high + 1]) % MOD
```
