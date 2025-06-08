from queue import PriorityQueue

class Solution:
    def lexicalOrder(self, n: int) -> list[int]:
        # Step 1: Create priority queue
        pq = PriorityQueue()

        # Step 2: Insert (string, number) into priority queue
        for i in range(1, n + 1):
            pq.put((str(i), i))  # string is used for comparison

        # Step 3: Prepare result list
        result = []

        # Step 4: Pop from queue and collect numbers
        while not pq.empty():
            result.append(pq.get()[1])

        # Step 5: Return the result
        return result