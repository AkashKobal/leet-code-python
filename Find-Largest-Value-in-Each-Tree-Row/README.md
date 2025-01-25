# Find Largest Value in Each Tree Row

Can you solve this real interview question? Find Largest Value in Each Tree Row - Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

 

Example 1:

[https://assets.leetcode.com/uploads/2020/08/21/largest_e1.jpg]


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]


Example 2:


Input: root = [1,2,3]
Output: [1,3]

## Solution
```py
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        arr=[]
        def preOrder(Node, level):
            if not Node: return
            if len(arr)<=level: arr.append(-2**31)
            arr[level]=max(arr[level], Node.val)

            preOrder(Node.left, level+1)
            preOrder(Node.right, level+1)
        
        preOrder(root, 0)
        return arr

```
