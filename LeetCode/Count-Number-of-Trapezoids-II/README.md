# Count Number of Trapezoids II

Can you solve this real interview question? Count Number of Trapezoids II - You are given a 2D integer array points where points[i] = [xi, yi] represents the coordinates of the ith point on the Cartesian plane.

Return the number of unique trapezoids that can be formed by choosing any four distinct points from points.

A trapezoid is a convex quadrilateral with at least one pair of parallel sides. Two lines are parallel if and only if they have the same slope.

 

Example 1:

Input: points = [[-3,2],[3,0],[2,3],[3,2],[2,-3]]

Output: 2

Explanation:

[https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-4.png] [https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-3.png]

There are two distinct ways to pick four points that form a trapezoid:

 * The points [-3,2], [2,3], [3,2], [2,-3] form one trapezoid.
 * The points [2,3], [3,2], [3,0], [2,-3] form another trapezoid.

Example 2:

Input: points = [[0,0],[1,0],[0,1],[2,1]]

Output: 1

Explanation:

[https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-5.png]

There is only one trapezoid which can be formed.