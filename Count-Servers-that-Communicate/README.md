# Count Servers that Communicate

Can you solve this real interview question? Count Servers that Communicate - You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.

Return the number of servers that communicate with any other server.

 

Example 1:

[https://assets.leetcode.com/uploads/2019/11/14/untitled-diagram-6.jpg]


Input: grid = [[1,0],[0,1]]
Output: 0
Explanation: No servers can communicate with others.

Example 2:

[https://assets.leetcode.com/uploads/2019/11/13/untitled-diagram-4.jpg]


Input: grid = [[1,0],[1,1]]
Output: 3
Explanation: All three servers can communicate with at least one other server.


Example 3:

[https://assets.leetcode.com/uploads/2019/11/14/untitled-diagram-1-3.jpg]


Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
Output: 4
Explanation: The two servers in the first row can communicate with each other. The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.

## Solution
```py
class Solution(object):
    def countServers(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m, n = len(grid), len(grid[0])
        row_cnt = [0] * m
        col_cnt = [0] * n

        # Count servers in each row and column
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    row_cnt[i] += 1
                    col_cnt[j] += 1

        cnt = 0
        # Count communicating servers
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    if row_cnt[i] > 1 or col_cnt[j] > 1:
                        cnt += 1

        return cnt
```
