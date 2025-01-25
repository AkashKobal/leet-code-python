# Shortest Distance After Road Addition Queries I

Can you solve this real interview question? Shortest Distance After Road Addition Queries I - You are given an integer n and a 2D integer array queries.

There are n cities numbered from 0 to n - 1. Initially, there is a unidirectional road from city i to city i + 1 for all 0 <= i < n - 1.

queries[i] = [ui, vi] represents the addition of a new unidirectional road from city ui to city vi. After each query, you need to find the length of the shortest path from city 0 to city n - 1.

Return an array answer where for each i in the range [0, queries.length - 1], answer[i] is the length of the shortest path from city 0 to city n - 1 after processing the first i + 1 queries.

 

Example 1:

Input: n = 5, queries = [[2,4],[0,2],[0,4]]

Output: [3,2,1]

Explanation:

[https://assets.leetcode.com/uploads/2024/06/28/image8.jpg]

After the addition of the road from 2 to 4, the length of the shortest path from 0 to 4 is 3.

[https://assets.leetcode.com/uploads/2024/06/28/image9.jpg]

After the addition of the road from 0 to 2, the length of the shortest path from 0 to 4 is 2.

[https://assets.leetcode.com/uploads/2024/06/28/image10.jpg]

After the addition of the road from 0 to 4, the length of the shortest path from 0 to 4 is 1.

Example 2:

Input: n = 4, queries = [[0,3],[0,2]]

Output: [1,1]

Explanation:

[https://assets.leetcode.com/uploads/2024/06/28/image11.jpg]

After the addition of the road from 0 to 3, the length of the shortest path from 0 to 3 is 1.

[https://assets.leetcode.com/uploads/2024/06/28/image12.jpg]

After the addition of the road from 0 to 2, the length of the shortest path remains 1.

## Solution
```py
class Solution:
    def updateDistances(self, graph, current, distances):
        newDist = distances[current] + 1
        
        for neighbor in graph[current]:
            if distances[neighbor] <= newDist:
                continue
                
            distances[neighbor] = newDist
            self.updateDistances(graph, neighbor, distances)
    
    def shortestDistanceAfterQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        distances = [n - 1 - i for i in range(n)]
        
        graph = [[] for _ in range(n)]
        for i in range(n-1):
            graph[i + 1].append(i)
        
        answer = []
        
        for source, target in queries:
            graph[target].append(source)
            distances[source] = min(distances[source], distances[target] + 1)
            self.updateDistances(graph, source, distances)
            
            answer.append(distances[0])
        
        return answer
```
