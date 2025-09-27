class Solution(object):
    def largestTriangleArea(self, points):
        length = len(points)
        area = 0
        for i in range(length):
            for j in range(i, length):
                for k in range (j, length):
                    x1 = points[i][0]
                    x2 = points[j][0]
                    x3 = points[k][0]

                    y1 = points[i][1]
                    y2 = points[j][1]
                    y3 = points[k][1]

                    area = max(abs(0.5 * (x1*(y2-y3) + x2*(y3 - y1) + x3*(y1-y2))), area)
        return area
      