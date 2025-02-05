# Check if One String Swap Can Make Strings Equal

Can you solve this real interview question? Check if One String Swap Can Make Strings Equal - You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.

 

Example 1:


Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".


Example 2:


Input: s1 = "attack", s2 = "defend"
Output: false
Explanation: It is impossible to make them equal with one string swap.


Example 3:


Input: s1 = "kelb", s2 = "kelb"
Output: true
Explanation: The two strings are already equal, so no string swap operation is required.

## Solution
```py
class Solution(object):
    def areAlmostEqual(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        i=-1
        j=-1
        cnt=0
        for k in range(0, len(s1)):
            if s1[k]!=s2[k]:
                cnt+=1
                if i==-1: i=k
                elif j==-1: j=k
        
        if cnt==0: return True
        elif cnt==2 and s1[i]==s2[j] and s1[j]==s2[i]: return True

        return False
```
