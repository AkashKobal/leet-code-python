# Merge Two Sorted Lists

Can you solve this real interview question? Merge Two Sorted Lists - You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:

[https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg]


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]


Example 2:


Input: list1 = [], list2 = []
Output: []


Example 3:


Input: list1 = [], list2 = [0]
Output: [0]

``` py
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy_node = ListNode() # creating a dummy node
        current_node = dummy_node # making dummy node as a current_node
        while list1 and list2: # traverse through each node of list1 and list2
            if list1.val < list2.val: # check if list1 value is less than list2
                current_node.next = list1 #append list1 node to current_node
                current_node = list1 # current_node becomes list1 node
                list1 = list1.next # move list1 pointer to next node
            else:
                current_node.next = list2
                current_node = list2
                list2 = list2.next  # move list2 pointer to next node
            
        current_node.next = list1 if list1 else list2
        return dummy_node.next
                
        
```
