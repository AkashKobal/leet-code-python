# Construct Smallest Number From DI String

Can you solve this real interview question? Construct Smallest Number From DI String - You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 'D' meaning decreasing.

A 0-indexed string num of length n + 1 is created using the following conditions:

 * num consists of the digits '1' to '9', where each digit is used at most once.
 * If pattern[i] == 'I', then num[i] < num[i + 1].
 * If pattern[i] == 'D', then num[i] > num[i + 1].

Return the lexicographically smallest possible string num that meets the conditions.

 

Example 1:


Input: pattern = "IIIDIDDD"
Output: "123549876"
Explanation:
At indices 0, 1, 2, and 4 we must have that num[i] < num[i+1].
At indices 3, 5, 6, and 7 we must have that num[i] > num[i+1].
Some possible values of num are "245639871", "135749862", and "123849765".
It can be proven that "123549876" is the smallest possible num that meets the conditions.
Note that "123414321" is not possible because the digit '1' is used more than once.

Example 2:


Input: pattern = "DDD"
Output: "4321"
Explanation:
Some possible values of num are "9876", "7321", and "8742".
It can be proven that "4321" is the smallest possible num that meets the conditions.

## Solution
```py
class Solution:
    def smallestNumber(self, pattern: str) -> str:
        n=len(pattern)
        d=[0]*n
        d[-1]+=(pattern[-1]=='D')
        for i in range(n-2, -1, -1):
            d[i]=d[i+1]+1 if pattern[i]=='D' else 0
        ans=[ chr(i+ord('1')) for i in range(n+1)]
        i=0
        while i<n:
            if pattern[i]=='D':
                l, r=i, i+d[i]
                while l<r:
                    ans[l], ans[r]=ans[r], ans[l]
                    l+=1
                    r-=1
            i+=d[i]+1
        return "".join(ans)

```
