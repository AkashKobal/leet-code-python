# Linked List in Binary Tree

Can you solve this real interview question? Linked List in Binary Tree - Given a binary tree root and a linked list with head as the first node. 

Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.

In this context downward path means a path that starts at some node and goes downwards.

 

Example 1:

[https://assets.leetcode.com/uploads/2020/02/12/sample_1_1720.png]


Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Explanation: Nodes in blue form a subpath in the binary Tree.  


Example 2:

[https://assets.leetcode.com/uploads/2020/02/12/sample_2_1720.png]


Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true


Example 3:


Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: false
Explanation: There is no path in the binary tree that contains all the elements of the linked list from head.

## Solution
```py
# Definition for a singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val  # Value of the node
        self.next = next  # Pointer to the next node in the linked list

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val  # Value of the node
        self.left = left  # Pointer to the left child in the binary tree
        self.right = right  # Pointer to the right child in the binary tree

class Solution:
    def isSubPath(self, head: Optional[ListNode], root: Optional[TreeNode]) -> bool:
        # Initialize a deque (double-ended queue) for BFS traversal of the binary tree
        d = deque()
        d.append(root)  # Start BFS with the root of the binary tree
        
        # Inner function to perform DFS to match the linked list starting from any tree node
        def dfs(node1, node2):
            if not node2:  # If we reached the end of the linked list, return True
                return True
            if not node1 or node1.val != node2.val:  # If the tree node is null or values do not match, return False
                return False
            # Continue DFS on both left and right children of the tree and next node in the linked list
            return dfs(node1.right, node2.next) or dfs(node1.left, node2.next)
        
        # Perform BFS on the binary tree
        while d:
            # Iterate through the nodes in the current level
            for _ in range(len(d)):
                curr = d.popleft()  # Pop the front of the deque
                
                # If the current tree node matches the head of the linked list and the linked list can be matched using DFS
                if curr.val == head.val and dfs(curr, head):
                    return True  # Return True if a subpath is found
                
                # Add the left child to the deque if it exists
                if curr.left:
                    d.append(curr.left)
                # Add the right child to the deque if it exists
                if curr.right:
                    d.append(curr.right)
        
        # Return False if no subpath is found in the binary tree
        return False

```
