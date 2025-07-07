# Maximum Number of Events That Can Be Attended

Can you solve this real interview question? Maximum Number of Events That Can Be Attended - You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.

Return the maximum number of events you can attend.

 

Example 1:

[https://assets.leetcode.com/uploads/2020/02/05/e1.png]


Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.


Example 2:


Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4