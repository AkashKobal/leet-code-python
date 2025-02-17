# Letter Tile Possibilities

Can you solve this real interview question? Letter Tile Possibilities - You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

 

Example 1:


Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".


Example 2:


Input: tiles = "AAABBC"
Output: 188


Example 3:


Input: tiles = "V"
Output: 1

## Solution
```py
class Solution:
    def buildChar(self, charCount):
        totalCount = 0
        for i in range(26):
            if charCount[i]:
                totalCount += 1
                charCount[i] -= 1
                totalCount += self.buildChar(charCount)
                charCount[i] += 1
        return totalCount

    def numTilePossibilities(self, tiles: str) -> int:
        charCount = [0] * 26
        for ch in tiles:
            charCount[ord(ch) - ord('A')] += 1
        return self.buildChar(charCount)
```
