# Course Schedule IV

Can you solve this real interview question? Course Schedule IV - There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course ai first if you want to take course bi.

 * For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.

Prerequisites can also be indirect. If course a is a prerequisite of course b, and course b is a prerequisite of course c, then course a is a prerequisite of course c.

You are also given an array queries where queries[j] = [uj, vj]. For the jth query, you should answer whether course uj is a prerequisite of course vj or not.

Return a boolean array answer, where answer[j] is the answer to the jth query.

 

Example 1:

[https://assets.leetcode.com/uploads/2021/05/01/courses4-1-graph.jpg]


Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
Output: [false,true]
Explanation: The pair [1, 0] indicates that you have to take course 1 before you can take course 0.
Course 0 is not a prerequisite of course 1, but the opposite is true.


Example 2:


Input: numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
Output: [false,false]
Explanation: There are no prerequisites, and each course is independent.


Example 3:

[https://assets.leetcode.com/uploads/2021/05/01/courses4-3-graph.jpg]


Input: numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
Output: [true,true]

## Solution
```py
class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        prereq_map = defaultdict(list) # course -> prereqs

        for prereq in prerequisites:
            prereq_map[prereq[1]].append(prereq[0])

        res = []
        memo = {}
        def dfs(course, prereq):
            if (course, prereq) in memo:
                return memo[(course, prereq)]
            
            course_prereqs = prereq_map[course]
            for p in course_prereqs:
                if p == prereq or dfs(p, prereq):
                    memo[(course, prereq)] = True
                    return True
            
            memo[(course, prereq)] = False
            return False
                
        return [dfs(query[1], query[0]) for query in queries]

```
