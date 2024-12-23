# Minimum Number of Operations to Sort a Binary Tree by Level

Can you solve this real interview question? Minimum Number of Operations to Sort a Binary Tree by Level - You are given the root of a binary tree with unique values.

In one operation, you can choose any two nodes at the same level and swap their values.

Return the minimum number of operations needed to make the values at each level sorted in a strictly increasing order.

The level of a node is the number of edges along the path between it and the root node.

 

Example 1:

[https://assets.leetcode.com/uploads/2022/09/18/image-20220918174006-2.png]


Input: root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
Output: 3
Explanation:
- Swap 4 and 3. The 2nd level becomes [3,4].
- Swap 7 and 5. The 3rd level becomes [5,6,8,7].
- Swap 8 and 7. The 3rd level becomes [5,6,7,8].
We used 3 operations so return 3.
It can be proven that 3 is the minimum number of operations needed.


Example 2:

[https://assets.leetcode.com/uploads/2022/09/18/image-20220918174026-3.png]


Input: root = [1,3,2,7,6,5,4]
Output: 3
Explanation:
- Swap 3 and 2. The 2nd level becomes [2,3].
- Swap 7 and 4. The 3rd level becomes [4,6,5,7].
- Swap 6 and 5. The 3rd level becomes [4,5,6,7].
We used 3 operations so return 3.
It can be proven that 3 is the minimum number of operations needed.


Example 3:

[https://assets.leetcode.com/uploads/2022/09/18/image-20220918174052-4.png]


Input: root = [1,2,3,4,5,6]
Output: 0
Explanation: Each level is already sorted in increasing order so return 0.

## Solution
```py
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minimumOperations(self, root: Optional[TreeNode]) -> int:
        def dfs(i, idx, viz):
            if viz[i]: return 0
            viz[i]=True
            j=idx[i]
            return 1+dfs(j, idx, viz)

        q=deque()
        q.append(root)
        swaps=0
        while q:
            qz=len(q)
            arr=[0]*qz
            for i in range(qz):
                node=q.popleft()
                arr[i]=node.val
                if node.left: q.append(node.left)
                if node.right: q.append(node.right)
            idx=sorted(range(qz), key = lambda k : arr[k])

            viz=[False]*qz
            for i in range(qz):
                if not viz[i]:
                    swaps+=dfs(i, idx, viz)-1
        return swaps

```
