# The k-th Lexicographical String of All Happy Strings of Length n

Can you solve this real interview question? The k-th Lexicographical String of All Happy Strings of Length n - A happy string is a string that:

 * consists only of letters of the set ['a', 'b', 'c'].
 * s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).

For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are less than k happy strings of length n.

 

Example 1:


Input: n = 1, k = 3
Output: "c"
Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".


Example 2:


Input: n = 1, k = 4
Output: ""
Explanation: There are only 3 happy strings of length 1.


Example 3:


Input: n = 3, k = 9
Output: "cab"
Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"

## Solution
```py
class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        sz=3*(1<<(n-1))
        if k>sz: return ""

        q, r=divmod(k-1, 1<<(n-1))
        s=[' ']*n
        s[0]=chr(ord('a') + q)
        
        B=format(r, f'0{n-1}b')  # Equivalent to bitset<9> bin(r) with n-1 bits

        xx = [['b', 'c'], ['a', 'c'], ['a', 'b']]
        
        for i in range(n-1):  # Iterating from 0 to n-2
            idx=ord(s[i]) - ord('a')
            s[i+1]=xx[idx][1] if B[i]=='1' else xx[idx][0]

        return "".join(s)
```
