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
