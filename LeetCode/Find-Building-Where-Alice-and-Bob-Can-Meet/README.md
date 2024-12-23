# Find Building Where Alice and Bob Can Meet

Can you solve this real interview question? Find Building Where Alice and Bob Can Meet - You are given a 0-indexed array heights of positive integers, where heights[i] represents the height of the ith building.

If a person is in building i, they can move to any other building j if and only if i < j and heights[i] < heights[j].

You are also given another array queries where queries[i] = [ai, bi]. On the ith query, Alice is in building ai while Bob is in building bi.

Return an array ans where ans[i] is the index of the leftmost building where Alice and Bob can meet on the ith query. If Alice and Bob cannot move to a common building on query i, set ans[i] to -1.

 

Example 1:


Input: heights = [6,4,8,5,2,7], queries = [[0,1],[0,3],[2,4],[3,4],[2,2]]
Output: [2,5,-1,5,2]
Explanation: In the first query, Alice and Bob can move to building 2 since heights[0] < heights[2] and heights[1] < heights[2]. 
In the second query, Alice and Bob can move to building 5 since heights[0] < heights[5] and heights[3] < heights[5]. 
In the third query, Alice cannot meet Bob since Alice cannot move to any other building.
In the fourth query, Alice and Bob can move to building 5 since heights[3] < heights[5] and heights[4] < heights[5].
In the fifth query, Alice and Bob are already in the same building.  
For ans[i] != -1, It can be shown that ans[i] is the leftmost building where Alice and Bob can meet.
For ans[i] == -1, It can be shown that there is no building where Alice and Bob can meet.


Example 2:


Input: heights = [5,3,8,2,6,1,4,6], queries = [[0,7],[3,5],[5,2],[3,0],[1,6]]
Output: [7,6,-1,4,6]
Explanation: In the first query, Alice can directly move to Bob's building since heights[0] < heights[7].
In the second query, Alice and Bob can move to building 6 since heights[3] < heights[6] and heights[5] < heights[6].
In the third query, Alice cannot meet Bob since Bob cannot move to any other building.
In the fourth query, Alice and Bob can move to building 4 since heights[3] < heights[4] and heights[0] < heights[4].
In the fifth query, Alice can directly move to Bob's building since heights[1] < heights[6].
For ans[i] != -1, It can be shown that ans[i] is the leftmost building where Alice and Bob can meet.
For ans[i] == -1, It can be shown that there is no building where Alice and Bob can meet.

## Solution
```py
class Solution:
    def leftmostBuildingQueries(self, heights: List[int], queries: List[List[int]]) -> List[int]:
        n = len(heights)
        st = [[0] * 20 for _ in range(n)]
        Log = [-1] * (n + 1)
        Log[0] = -1
        for i in range(1, n + 1):
            Log[i] = Log[i >> 1] + 1
        for i in range(n):
            st[i][0] = heights[i]
        for i in range(1, 20):
            for j in range(n):
                if j + (1 << i) <= n:
                    st[j][i] = max(st[j][i - 1], st[j + (1 << (i - 1))][i - 1])

        def Ask(l, r):
            k = Log[r - l + 1]
            return max(st[l][k], st[r - (1 << k) + 1][k])

        res = []
        for l, r in queries:
            if l > r:
                l, r = r, l
            if l == r:
                res.append(l)
                continue
            if heights[r] > heights[l]:
                res.append(r)
                continue
            max_height = max(heights[r], heights[l])
            left, right = r + 1, n
            while left < right:
                mid = (left + right) // 2
                if Ask(r + 1, mid) > max_height:
                    right = mid
                else:
                    left = mid + 1
            res.append(left if left != n else -1)
        return res
```
