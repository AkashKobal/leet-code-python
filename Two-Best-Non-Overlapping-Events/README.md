# Two Best Non-Overlapping Events

Can you solve this real interview question? Two Best Non-Overlapping Events - You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei]. The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei. You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.

Return this maximum sum.

Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts and the other ends at the same time. More specifically, if you attend an event with end time t, the next event must start at or after t + 1.

 

Example 1:

[https://assets.leetcode.com/uploads/2021/09/21/picture5.png]


Input: events = [[1,3,2],[4,5,2],[2,4,3]]
Output: 4
Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.


Example 2:

Example 1 Diagram [https://assets.leetcode.com/uploads/2021/09/21/picture1.png]


Input: events = [[1,3,2],[4,5,2],[1,5,5]]
Output: 5
Explanation: Choose event 2 for a sum of 5.


Example 3:

[https://assets.leetcode.com/uploads/2021/09/21/picture3.png]


Input: events = [[1,5,3],[1,5,1],[6,6,5]]
Output: 8
Explanation: Choose events 0 and 2 for a sum of 3 + 5 = 8.

## Solution
```py
from typing import List

class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        n = len(events)
        
        # Step 1: Sort the events by their start time
        events.sort(key=lambda x: x[0])
        
        # Step 2: Create the suffix array for the maximum event value from each event onward
        suffixMax = [0] * n
        suffixMax[n - 1] = events[n - 1][2]  # Initialize the last event's value
        
        # Populate the suffixMax array
        for i in range(n - 2, -1, -1):
            suffixMax[i] = max(events[i][2], suffixMax[i + 1])
        
        # Step 3: For each event, find the next event that starts after it ends
        maxSum = 0
        
        for i in range(n):
            left, right = i + 1, n - 1
            nextEventIndex = -1
            
            # Perform binary search to find the next non-overlapping event
            while left <= right:
                mid = left + (right - left) // 2
                if events[mid][0] > events[i][1]:
                    nextEventIndex = mid
                    right = mid - 1
                else:
                    left = mid + 1
            
            # If a valid next event is found, update the max sum
            if nextEventIndex != -1:
                maxSum = max(maxSum, events[i][2] + suffixMax[nextEventIndex])
            
            # Also consider the case where we take only the current event
            maxSum = max(maxSum, events[i][2])
        
        return maxSum
```
