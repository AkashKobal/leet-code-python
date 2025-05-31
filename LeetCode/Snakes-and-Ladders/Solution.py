from collections import deque

class Solution:
    def snakesAndLadders(self, board: list[list[int]]) -> int:
        n = len(board)

        def get_coordinates(pos: int) -> tuple[int, int]:
            """Convert 1-based position to (row, col) with zig-zag handling."""
            r, c = divmod(pos - 1, n)
            row = n - 1 - r
            col = c if r % 2 == 0 else n - 1 - c
            return row, col

        visited = set()
        queue = deque([(1, 0)])  # (square number, moves)

        while queue:
            pos, moves = queue.popleft()
            for i in range(1, 7):
                next_pos = pos + i
                if next_pos > n * n:
                    continue
                r, c = get_coordinates(next_pos)
                if board[r][c] != -1:
                    next_pos = board[r][c]
                if next_pos == n * n:
                    return moves + 1
                if next_pos not in visited:
                    visited.add(next_pos)
                    queue.append((next_pos, moves + 1))
        return -1