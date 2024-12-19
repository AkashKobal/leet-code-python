# Max Chunks To Make Sorted

Can you solve this real interview question? Max Chunks To Make Sorted - You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].

We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.

Return the largest number of chunks we can make to sort the array.

 

Example 1:


Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.


Example 2:


Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.

## Solution
```py
class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        # Initialize variables
        max_seen = 0
        chunks = 0

        # Iterate through the array
        for i, num in enumerate(arr):
            # Update the maximum value seen so far
            max_seen = max(max_seen, num)

            # If the maximum value seen so far equals the current index,
            # it means we can form a chunk up to this point.
            if max_seen == i:
                chunks += 1

        return chunks
```
