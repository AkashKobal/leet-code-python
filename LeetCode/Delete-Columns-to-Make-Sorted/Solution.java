1class Solution {
2    public int minDeletionSize(String[] strs) {
3        int res = 0;
4        for (int j = 0; j < strs[0].length(); j++)
5            res += isUnsorted(strs, j);
6        return res;
7    }
8
9    private int isUnsorted(String[] strs, int j) {
10        for (int i = 1; i < strs.length; i++)
11            if (strs[i].charAt(j) < strs[i - 1].charAt(j))
12                return 1;
13        return 0;
14    }
15}
16