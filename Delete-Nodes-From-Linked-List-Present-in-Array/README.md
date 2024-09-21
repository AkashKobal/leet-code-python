# Delete Nodes From Linked List Present in Array

Can you solve this real interview question? Delete Nodes From Linked List Present in Array - You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.

 

Example 1:

Input: nums = [1,2,3], head = [1,2,3,4,5]

Output: [4,5]

Explanation:

[https://assets.leetcode.com/uploads/2024/06/11/linkedlistexample0.png]

Remove the nodes with values 1, 2, and 3.

Example 2:

Input: nums = [1], head = [1,2,1,2,1,2]

Output: [2,2,2]

Explanation:

[https://assets.leetcode.com/uploads/2024/06/11/linkedlistexample1.png]

Remove the nodes with value 1.

Example 3:

Input: nums = [5], head = [1,2,3,4]

Output: [1,2,3,4]

Explanation:

[https://assets.leetcode.com/uploads/2024/06/11/linkedlistexample2.png]

No node has value 5.

## Solution
```py
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def modifiedList(self, nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:
        # Convert nums list to a set for O(1) lookup.
        s = set(nums)
        
        # Remove initial nodes in the list that have values in the set.
        while head and head.val in s:
            head = head.next  # Move head to the next node.

        # If the list is empty after removals, return None.
        if not head:
            return None

        # Initialize two pointers, prev and curr.
        prev = head  # Set prev to the current head.
        curr = head.next  # Set curr to the node next to head.

        # Traverse through the list to remove nodes with values in the set.
        while curr:
            if curr.val not in s:  # If current node value is not in the set,
                prev.next = curr  # Link previous node to current node.
                prev = curr  # Move prev to curr.
            curr = curr.next  # Move curr to the next node.

        # Terminate the list to avoid potential cycles or leftover nodes.
        prev.next = None
        return head  # Return the modified list head.
```
