# Split Linked List in Parts

Can you solve this real interview question? Split Linked List in Parts - Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the k parts.

 

Example 1:

[https://assets.leetcode.com/uploads/2021/06/13/split1-lc.jpg]


Input: head = [1,2,3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but its string representation as a ListNode is [].


Example 2:

[https://assets.leetcode.com/uploads/2021/06/13/split2-lc.jpg]


Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
Output: [[1,2,3,4],[5,6,7],[8,9,10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.

## Solution
```py
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def splitListToParts(self, head: Optional[ListNode], k: int) -> List[Optional[ListNode]]:

        # Step 1: Calculate the length of the linked list
        n = 0
        curr = head
        while curr:
            n += 1  # Increment the length correctly
            curr = curr.next
        
        # Step 2: Determine the base size and how many parts need an extra node
        base = n // k  # Minimum size of each part
        extra = n % k  # Number of parts that get an extra node
        
        # Step 3: Split the linked list
        res = []
        curr = head
        for i in range(k):
            part_head = curr  # This is the head of the current part
            part_size = base + (1 if extra > 0 else 0)  # Add 1 more node to the first 'extra' parts
            extra -= 1  # Decrease extra after assigning an extra node
            
            # Now, advance the pointer `part_size - 1` steps to get to the end of the current part
            for _ in range(part_size - 1):
                if curr:
                    curr = curr.next
            
            # After advancing, break the current part if necessary
            if curr:
                next_part = curr.next  # The head of the next part
                curr.next = None  # Break the list here
                curr = next_part  # Move to the next part
            
            res.append(part_head)  # Add the head of the current part to the result
        
        return res
        ```
