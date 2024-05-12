# Middle of the Linked List

Can you solve this real interview question? Middle of the Linked List - Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:

[https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg]


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.


Example 2:

[https://assets.leetcode.com/uploads/2021/07/23/lc-midlist2.jpg]


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

# Solution
``` py
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = head # initilize slow and fast to head
        fast = head
        while fast is not None and fast.next is not None: 
            slow = slow.next # iterate slow for only one node at a time
            fast = fast.next.next # iterate fast for two node at a time
        return slow # if the fast and fast.next reaches None
        # know where the slow is found that node will be the middle node
  ```
