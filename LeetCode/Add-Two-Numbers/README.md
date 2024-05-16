# Add Two Numbers

Can you solve this real interview question? Add Two Numbers - You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:

[https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg]


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.


Example 2:


Input: l1 = [0], l2 = [0]
Output: [0]


Example 3:


Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

```py
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        head = ListNode(0) # creating a list node and initializing to zero
        root = head
        carry = 0 # carry becz, while performing addition operation
        while l1 or l2:
            val1 = l1.val if l1 else 0 # storing l1 values into val1 variable
            val2 = l2.val if l2 else 0 # storing l2 values into val2 variable
            s  = val1 + val2 + carry # proforming addition operation
            carry = s//10 
            head.next = ListNode(s % 10)
            head = head.next

            if l1:
                l1 = l1.next

            if l2:
                l2 = l2.next

        if carry:
            head.next = ListNode(carry) # create a carry node and join it to the end of the ListNode for calculation
        
        return root.next

```
