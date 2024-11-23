# Rotating the Box

Can you solve this real interview question? Rotating the Box - You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:

 * A stone '#'
 * A stationary obstacle '*'
 * Empty '.'

The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.

It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.

Return an n x m matrix representing the box after the rotation described above.

 

Example 1:

[https://assets.leetcode.com/uploads/2021/04/08/rotatingtheboxleetcodewithstones.png]


Input: box = [["#",".","#"]]
Output: [["."],
         ["#"],
         ["#"]]


Example 2:

[https://assets.leetcode.com/uploads/2021/04/08/rotatingtheboxleetcode2withstones.png]


Input: box = [["#",".","*","."],
              ["#","#","*","."]]
Output: [["#","."],
         ["#","#"],
         ["*","*"],
         [".","."]]


Example 3:

[https://assets.leetcode.com/uploads/2021/04/08/rotatingtheboxleetcode3withstone.png]


Input: box = [["#","#","*",".","*","."],
              ["#","#","#","*",".","."],
              ["#","#","#",".","#","."]]
Output: [[".","#","#"],
         [".","#","#"],
         ["#","#","*"],
         ["#","*","."],
         ["#",".","*"],
         ["#",".","."]]

## Solution
```py
class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        r, c=len(box), len(box[0])
        rotate=[['.']*r for _ in range(c)]
        for i, row in enumerate(box):
            bottom=c-1
            for j in range(c-1, -1, -1):
                if row[j]=='#':
                    rotate[bottom][r-1-i]='#'
                    bottom-=1
                elif row[j]=='*':
                    rotate[j][r-1-i]='*'
                    bottom=j-1
        return rotate

```
