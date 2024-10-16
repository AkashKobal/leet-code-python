# Longest Happy String

Can you solve this real interview question? Longest Happy String - A string s is called happy if it satisfies the following conditions:

 * s only contains the letters 'a', 'b', and 'c'.
 * s does not contain any of "aaa", "bbb", or "ccc" as a substring.
 * s contains at most a occurrences of the letter 'a'.
 * s contains at most b occurrences of the letter 'b'.
 * s contains at most c occurrences of the letter 'c'.

Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".

A substring is a contiguous sequence of characters within a string.

 

Example 1:


Input: a = 1, b = 1, c = 7
Output: "ccaccbcc"
Explanation: "ccbccacc" would also be a correct answer.


Example 2:


Input: a = 7, b = 1, c = 0
Output: "aabaa"
Explanation: It is the only correct answer in this case.

```py
import heapq

class Solution:
    def longestDiverseString(self, a: int, b: int, c: int) -> str:
        # Max-heap of available characters and their counts
        heap = []
        if a > 0:
            heapq.heappush(heap, (-a, 'a'))
        if b > 0:
            heapq.heappush(heap, (-b, 'b'))
        if c > 0:
            heapq.heappush(heap, (-c, 'c'))

        result = []
        
        # While there are still characters left to append
        while heap:
            # Get the character with the most remaining occurrences
            count1, char1 = heapq.heappop(heap)
            
            # Check if appending this character would violate the rule
            if len(result) >= 2 and result[-1] == result[-2] == char1:
                if not heap:
                    break  # No other characters to use, stop
                # Otherwise, take the next most frequent character
                count2, char2 = heapq.heappop(heap)
                result.append(char2)
                if count2 + 1 < 0:
                    heapq.heappush(heap, (count2 + 1, char2))  # Push back if any left
                # Push the first character back into the heap
                heapq.heappush(heap, (count1, char1))
            else:
                # Safe to append char1
                result.append(char1)
                if count1 + 1 < 0:
                    heapq.heappush(heap, (count1 + 1, char1))  # Push back if any left
        
        return ''.join(result)
```
