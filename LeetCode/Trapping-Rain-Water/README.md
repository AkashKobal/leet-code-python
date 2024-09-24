# Trapping Rain Water

Can you solve this real interview question? Trapping Rain Water - Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:

[https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png]


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.


Example 2:


Input: height = [4,2,0,3,2,5]
Output: 9

## Solution
```py
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        l,r=0,len(height)-1
        leftmax , rightmax =height[l],height[r]
        water=0
        while l<r:
            if leftmax<rightmax:
                l+=1
                leftmax=max(leftmax,height[l])
                water+=leftmax-height[l]
            else:
                r-=1
                rightmax=max(rightmax,height[r])
                water+=rightmax-height[r]
        return water
```
