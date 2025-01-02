# Count Vowel Strings in Ranges

Can you solve this real interview question? Count Vowel Strings in Ranges - You are given a 0-indexed array of strings words and a 2D array of integers queries.

Each query queries[i] = [li, ri] asks us to find the number of strings present in the range li to ri (both inclusive) of words that start and end with a vowel.

Return an array ans of size queries.length, where ans[i] is the answer to the ith query.

Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:


Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
Output: [2,3,0]
Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
The answer to the query [0,2] is 2 (strings "aba" and "ece").
to query [1,4] is 3 (strings "ece", "aa", "e").
to query [1,1] is 0.
We return [2,3,0].


Example 2:


Input: words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
Output: [3,2,1]
Explanation: Every string satisfies the conditions, so we return [3,2,1].

## Solution
```py
class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        isVowel=1+(1<<(ord('e')-ord('a')))+(1<<(ord('i')-ord('a')))+(1<<(ord('o')-ord('a')))+(1<<(ord('u')-ord('a')))
        n, qz=len(words), len(queries)
        cnt=[0]*(n+1)
        for i, w in enumerate(words):
            cnt[i+1]=cnt[i]+(((1<<(ord(w[0])-ord('a')))& isVowel)!=0 and ((1<<(ord(w[-1])-ord('a')))& isVowel)!=0)
        ans=[0]*qz
        for i, (q0, q1) in enumerate(queries):
            ans[i]=cnt[q1+1]-cnt[q0]
        return ans
        

```
