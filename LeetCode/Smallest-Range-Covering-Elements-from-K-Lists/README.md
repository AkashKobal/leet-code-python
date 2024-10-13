# Smallest Range Covering Elements from K Lists

Can you solve this real interview question? Smallest Range Covering Elements from K Lists - You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.

 

Example 1:


Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].


Example 2:


Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
Output: [1,1]

```py
import heapq

class Solution:
    def smallestRange(self, nums: List[List[int]]) -> List[int]:
        # Min-heap to track the smallest element across all lists
        min_heap = []
        current_max = float('-inf')  # Track the current largest element in the window
        
        # Initialize the heap with the first element from each list
        for i in range(len(nums)):
            heapq.heappush(min_heap, (nums[i][0], i, 0))  # (value, list_index, element_index)
            current_max = max(current_max, nums[i][0])  # Update the max value
        
        # Initialize the result range to a very large one
        result_range = [-10**5, 10**5]
        
        while min_heap:
            current_min, list_idx, elem_idx = heapq.heappop(min_heap)  # Pop the smallest element
            
            # Check if the current range [current_min, current_max] is smaller
            if current_max - current_min < result_range[1] - result_range[0]:
                result_range = [current_min, current_max]
            
            # If we have reached the end of one of the lists, break the loop
            if elem_idx + 1 == len(nums[list_idx]):
                break
            
            # Otherwise, push the next element from the same list into the heap
            next_elem = nums[list_idx][elem_idx + 1]
            heapq.heappush(min_heap, (next_elem, list_idx, elem_idx + 1))
            
            # Update the max value
            current_max = max(current_max, next_elem)
        
        return result_range
```
