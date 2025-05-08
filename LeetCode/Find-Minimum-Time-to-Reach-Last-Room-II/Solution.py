import heapq

class Solution:
    def minTimeToReach(self, moveTime):
        n, m = len(moveTime), len(moveTime[0])
        vis = [[False] * m for _ in range(n)]
        heap = [(0, 0, 0, 0)]  # (time, moves, row, col)
        vis[0][0] = True
        dirs = [(0,1), (1,0), (-1,0), (0,-1)]

        while heap:
            time, moves, r, c = heapq.heappop(heap)
            if r == n - 1 and c == m - 1:
                return time
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < m and not vis[nr][nc]:
                    vis[nr][nc] = True
                    wait = max(time, moveTime[nr][nc])
                    travel_time = 1 if moves % 2 == 0 else 2
                    heapq.heappush(heap, (wait + travel_time, moves + 1, nr, nc))
        return -1