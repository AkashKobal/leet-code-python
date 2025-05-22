class Solution:
    def maxRemoval(self, nums: List[int], queries: List[List[int]]) -> int:
        n, q = len(nums), len(queries)
        starts = [[] for _ in range(n)]
        for l, r in queries:
            starts[l].append(r)

        avail = []   # max‐heap of ends (store negatives)
        active = []  # min‐heap of ends
        chosen = 0
        for i in range(n):
            for r in starts[i]:
                heapq.heappush(avail, -r)

            while active and active[0] < i:
                heapq.heappop(active)

            need = nums[i] - len(active)
            for _ in range(need):
                while avail and -avail[0] < i:
                    heapq.heappop(avail)
                if not avail:
                    return -1
                r = -heapq.heappop(avail)
                heapq.heappush(active, r)
                chosen += 1
        return q - chosen