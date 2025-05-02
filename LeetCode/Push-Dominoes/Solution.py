class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        dominoes = list(dominoes)
        n = len(dominoes)
        last_right = -1
        last_left = 0

        for i, d in enumerate(dominoes):
            if d == 'R':
                if last_right != -1:
                    for j in range(last_right + 1, i):
                        dominoes[j] = 'R'
                last_right = i
            elif d == 'L':
                if last_right != -1:
                    l, r = last_right + 1, i - 1
                    while l < r:
                        dominoes[l], dominoes[r] = 'R', 'L'
                        l += 1
                        r -= 1
                    last_right = -1
                else:
                    for j in range(last_left, i):
                        dominoes[j] = 'L'
                last_left = i

        if last_right != -1:
            for i in range(last_right + 1, n):
                dominoes[i] = 'R'

        return ''.join(dominoes)