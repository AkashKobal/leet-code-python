class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        heap=[(x, i) for i, x in enumerate(nums)]
        heapify(heap)
        for _ in range(k):
            x, i=heap[0]
            heapreplace(heap, (x*multiplier, i))
        for x, i in heap:
            nums[i]=x
        return nums


        