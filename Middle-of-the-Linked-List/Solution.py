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
        
