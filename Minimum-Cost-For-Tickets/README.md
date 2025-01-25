# Minimum Cost For Tickets

Can you solve this real interview question? Minimum Cost For Tickets - You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.

Train tickets are sold in three different ways:

 * a 1-day pass is sold for costs[0] dollars,
 * a 7-day pass is sold for costs[1] dollars, and
 * a 30-day pass is sold for costs[2] dollars.

The passes allow that many days of consecutive travel.

 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.

Return the minimum number of dollars you need to travel every day in the given list of days.

 

Example 1:


Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total, you spent $11 and covered all the days of your travel.


Example 2:


Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total, you spent $17 and covered all the days of your travel.

## Solution
```py
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        # Create a set of travel days for quick lookup
        travel_days = set(days)

        # Initialize a DP array for 365 days
        dp = [0] * 366  # dp[i] is the min cost to travel up to day i

        for i in range(1, 366):
            if i not in travel_days:
                # If it's not a travel day, the cost is the same as the previous day
                dp[i] = dp[i - 1]
            else:
                # Calculate the cost if we buy a 1-day, 7-day, or 30-day pass
                cost1 = dp[i - 1] + costs[0]
                cost7 = dp[max(0, i - 7)] + costs[1]
                cost30 = dp[max(0, i - 30)] + costs[2]
                
                # Take the minimum of the three options
                dp[i] = min(cost1, cost7, cost30)

        # Return the cost to cover all days in the year
        return dp[365]
```
