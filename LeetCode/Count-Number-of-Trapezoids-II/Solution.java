1import java.util.*;
2
3class Solution {
4    public int countTrapezoids(int[][] points) {
5        HashMap<Integer, HashMap<Integer, Integer>> t = new HashMap<>();
6        HashMap<Integer, HashMap<Integer, Integer>> v = new HashMap<>();
7
8        int n = points.length;
9
10        for (int i = 0; i < n; i++) {
11            for (int j = i + 1; j < n; j++) {
12
13                int dx = points[j][0] - points[i][0];
14                int dy = points[j][1] - points[i][1];
15
16                if (dx < 0 || (dx == 0 && dy < 0)) {
17                    dx = -dx;
18                    dy = -dy;
19                }
20
21                int g = gcd(dx, Math.abs(dy));
22                int sx = dx / g;
23                int sy = dy / g;
24
25                int des = sx * points[i][1] - sy * points[i][0];
26
27                int key1 = (sx << 12) | (sy + 2000);
28                int key2 = (dx << 12) | (dy + 2000);
29
30                t.computeIfAbsent(key1, k -> new HashMap<>()).merge(des, 1, Integer::sum);
31                v.computeIfAbsent(key2, k -> new HashMap<>()).merge(des, 1, Integer::sum);
32            }
33        }
34
35        return count(t) - count(v) / 2;
36    }
37
38    private int count(HashMap<Integer, HashMap<Integer, Integer>> map) {
39        long ans = 0;
40
41        for (HashMap<Integer, Integer> inner : map.values()) {
42            long sum = 0;
43
44            for (int val : inner.values()) sum += val;
45
46            for (int val : inner.values()) {
47                sum -= val;
48                ans += (long) val * sum;
49            }
50        }
51
52        return (int) ans;
53    }
54
55    private int gcd(int a, int b) {
56        while (b != 0) {
57            int t = a % b;
58            a = b;
59            b = t;
60        }
61        return Math.abs(a);
62    }
63}