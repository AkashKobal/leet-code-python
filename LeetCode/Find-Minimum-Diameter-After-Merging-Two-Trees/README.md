# Find Minimum Diameter After Merging Two Trees

Can you solve this real interview question? Find Minimum Diameter After Merging Two Trees - There exist two undirected trees with n and m nodes, numbered from 0 to n - 1 and from 0 to m - 1, respectively. You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the second tree.

You must connect one node from the first tree with another node from the second tree with an edge.

Return the minimum possible diameter of the resulting tree.

The diameter of a tree is the length of the longest path between any two nodes in the tree.

 

Example 1:[https://assets.leetcode.com/uploads/2024/04/22/example11-transformed.png]

Input: edges1 = [[0,1],[0,2],[0,3]], edges2 = [[0,1]]

Output: 3

Explanation:

We can obtain a tree of diameter 3 by connecting node 0 from the first tree with any node from the second tree.

Example 2:

[https://assets.leetcode.com/uploads/2024/04/22/example211.png]

Input: edges1 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]], edges2 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]

Output: 5

Explanation:

We can obtain a tree of diameter 5 by connecting node 0 from the first tree with node 0 from the second tree.

## Solution
```py
from collections import defaultdict, deque
import heapq

class Solution:
    def minimumDiameterAfterMerge(self, edges1, edges2):
        # Step 1: Build adjacency list for both trees
        adjList1 = self.buildAdjList(edges1)
        adjList2 = self.buildAdjList(edges2)
        
        # Step 2: Perform topological sorting (actually it's the two farthest nodes approach)
        diameter1 = self.topologicalSort(adjList1)
        diameter2 = self.topologicalSort(adjList2)
        
        # Step 3: Extract longest and second longest distances from the two trees
        secondLongest1 = 0
        longest1 = 0
        secondLongest2 = 0
        longest2 = 0
        
        if len(diameter1) == 2:
            secondLongest1 = heapq.heappop(diameter1)
            longest1 = heapq.heappop(diameter1)
        else:
            longest1 = heapq.heappop(diameter1)
        
        if len(diameter2) == 2:
            secondLongest2 = heapq.heappop(diameter2)
            longest2 = heapq.heappop(diameter2)
        else:
            longest2 = heapq.heappop(diameter2)
        
        # Step 4: Return the maximum possible diameter after merging
        return max(secondLongest1 + longest1, max(secondLongest2 + longest2, longest1 + longest2 + 1))
    
    def topologicalSort(self, adjList):
        # This function returns the two largest distances using a topological traversal like BFS/DFS
        indegree = {key: len(adjList[key]) for key in adjList}
        queue = deque()
        res = []
        
        # Initialize queue with nodes having only one edge
        for key in adjList:
            if indegree[key] == 1:
                queue.append((key, 0))
        
        while queue:
            node, dist = queue.popleft()
            
            for adj in adjList[node]:
                if indegree[adj] > 0:
                    if indegree[adj] > 1:
                        indegree[adj] -= 1
                    if indegree[adj] == 1:
                        queue.append((adj, dist + 1))
                        heapq.heappush(res, dist + 1)
                        if len(res) > 2:
                            heapq.heappop(res)
            
            indegree[node] -= 1
            if not queue:
                break
        
        if not res:
            res.append(0)
        
        return res
    
    def buildAdjList(self, edges):
        # This function builds the adjacency list from the edges list
        adjList = defaultdict(list)
        
        for u, v in edges:
            adjList[u].append(v)
            adjList[v].append(u)
        
        return adjList
```
