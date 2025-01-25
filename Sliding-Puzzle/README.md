# Sliding Puzzle

Can you solve this real interview question? Sliding Puzzle - On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0. A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given the puzzle board board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.

 

Example 1:

[https://assets.leetcode.com/uploads/2021/06/29/slide1-grid.jpg]


Input: board = [[1,2,3],[4,0,5]]
Output: 1
Explanation: Swap the 0 and the 5 in one move.


Example 2:

[https://assets.leetcode.com/uploads/2021/06/29/slide2-grid.jpg]


Input: board = [[1,2,3],[5,4,0]]
Output: -1
Explanation: No number of moves will make the board solved.


Example 3:

[https://assets.leetcode.com/uploads/2021/06/29/slide3-grid.jpg]


Input: board = [[4,1,2],[5,0,3]]
Output: 5
Explanation: 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]

## Solution
```py
from collections import deque
from typing import List

class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        # Target state and initial state
        target = "123450"
        start = ''.join(str(num) for row in board for num in row)
        
        # Neighbors map for each index in the 1D representation of the board
        neighbors = {
            0: [1, 3], 1: [0, 2, 4], 2: [1, 5],
            3: [0, 4], 4: [1, 3, 5], 5: [2, 4]
        }
        
        # BFS setup
        queue = deque([(start, 0)])  # (state, moves)
        visited = set()
        visited.add(start)
        
        while queue:
            state, moves = queue.popleft()
            
            # Check if we've reached the target
            if state == target:
                return moves
            
            # Find the index of zero
            zero_index = state.index('0')
            
            # Generate new states by swapping '0' with its neighbors
            for neighbor in neighbors[zero_index]:
                # Convert state to a list for mutation
                new_state = list(state)
                # Swap '0' with the neighbor
                new_state[zero_index], new_state[neighbor] = new_state[neighbor], new_state[zero_index]
                # Convert back to string
                new_state_str = ''.join(new_state)
                
                # If this new state hasn't been visited, add it to the queue
                if new_state_str not in visited:
                    visited.add(new_state_str)
                    queue.append((new_state_str, moves + 1))
        
        # If we exhaust the queue without finding the target
        return -1
```
