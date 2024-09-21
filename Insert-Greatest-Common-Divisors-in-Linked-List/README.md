# Insert Greatest Common Divisors in Linked List

Can you solve this real interview question? Insert Greatest Common Divisors in Linked List - Given the head of a linked list head, in which each node contains an integer value.

Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.

Return the linked list after insertion.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.

 

Example 1:

[https://assets.leetcode.com/uploads/2023/07/18/ex1_copy.png]


Input: head = [18,6,10,3]
Output: [18,6,6,2,10,1,3]
Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes the linked list after inserting the new nodes (nodes in blue are the inserted nodes).
- We insert the greatest common divisor of 18 and 6 = 6 between the 1st and the 2nd nodes.
- We insert the greatest common divisor of 6 and 10 = 2 between the 2nd and the 3rd nodes.
- We insert the greatest common divisor of 10 and 3 = 1 between the 3rd and the 4th nodes.
There are no more adjacent nodes, so we return the linked list.


Example 2:

[https://assets.leetcode.com/uploads/2023/07/18/ex2_copy1.png]


Input: head = [7]
Output: [7]
Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes the linked list after inserting the new nodes.
There are no pairs of adjacent nodes, so we return the initial linked list.

## Solution
```py
class Solution(object):
    def gcd(self, a, b):
        # Function to compute the greatest common divisor (GCD) using the Euclidean algorithm
        while b:
            a, b = b, a % b  # Update a to b and b to a % b until b becomes 0
        return a  # Return the GCD

    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Function to insert GCDs between nodes in a linked list
        ans = ListNode(0)  # Create a dummy node to help build the new list
        cur = ans  # Pointer to the last node in the new list

        # Loop through the original linked list until the second last node
        while head.next:
            gcd_val = self.gcd(head.val, head.next.val)  # Calculate GCD of the current and next node values
            
            cur.next = ListNode(head.val)  # Create a new node for the current node's value
            cur.next.next = ListNode(gcd_val)  # Create a new node for the GCD value
            
            head = head.next  # Move to the next node in the original list
            cur = cur.next.next  # Move to the last node in the new list (the newly added GCD node)

        cur.next = ListNode(head.val)  # After exiting the loop, add the last node's value
        
        return ans.next  # Return the new list starting from the first actual node (skipping the dummy node)

```
